package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.second.SecondPersistenceService;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the selection service.
 */
@Component
public class SelectionServiceImpl implements SelectionService {
	
	/**
	 * Logging facility.
	 */
	private static final Logger logger = Logger.getLogger(SelectionServiceImpl.class);

	/**
	 * Persistence service.
	 */
	@Autowired
	private PersistenceService service;
	
	/**
	 * Entity manager.
	 */
	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * Service for second level entities.
	 */
	@Autowired
	private SecondPersistenceService secondService;
	
	/**
	 * The entities which are supported by this service.
	 */
	private Map<ClassEnum, java.lang.Class<? extends CerifEntity>> supportedEntities;

	/**
	 * Initialization.
	 */
	@PostConstruct
	public void initialize() {
		supportedEntities = new LinkedHashMap<ClassEnum, java.lang.Class<? extends CerifEntity>>();
		for (ClassEnum classEnum : ClassEnum.values()) {
			if (classEnum.getEntityClass() != null) {
				supportedEntities.put(classEnum, classEnum.getEntityClass());
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.SelectionService#select(gr.ekt.cerif.services.SelectionOptions)
	 */
	public SelectionResult select(SelectionOptions options) throws SelectionException {
		SelectionResult selectionResult = new SelectionResult();
		List<CerifEntity> result = new ArrayList<CerifEntity>();
		List<Field> linkFields = new ArrayList<Field>();
		
		long start = System.currentTimeMillis();	

		for (Entry<ClassEnum, java.lang.Class<? extends CerifEntity>> entry : supportedEntities.entrySet()) {
			ClassEnum enumeration = entry.getKey();
			if (!ClassEnum.CLASSIFICATION_SCHEME.equals(enumeration) &&
				hasEntities(enumeration, options)) {
				Object[] tempResult = retrieveEntities(entry.getValue(), options, enumeration);
				result.addAll((List<CerifEntity>)tempResult[0]);
				linkFields.addAll((List<Field>)tempResult[1]);
			}
		}
		
		if (hasEntities(ClassEnum.CLASSIFICATION_SCHEME, options)) {
			List<ClassScheme> schemeList = (List<ClassScheme>)retrieveEntities(ClassScheme.class, options, ClassEnum.CLASSIFICATION_SCHEME)[0];
			if (schemeList != null && !schemeList.isEmpty()) {
				boolean embedClasses = hasEmbeddedEntities(ClassEnum.CLASSIFICATION, options);
				for (ClassScheme classScheme : schemeList) {
					if (embedClasses) {
						Set<Class> classes = new HashSet<Class>(service.getSemanticService().getClassRepository().retrieveCompleteClassInformationForScheme(classScheme));
						classScheme.setClasses(classes);
					} else {
						classScheme.setClasses(new HashSet<Class>());
					}
					result.add(classScheme);
				}
			}			
		}
		
		// Check whether entities, from the other side of some links, should be fetched.
		List<CerifEntity> additionalEntities = null;
		if (options.getLinkedObjects() != null && !options.getLinkedObjects().isEmpty() && !result.isEmpty()) {
			additionalEntities = retrieveEntitiesFromOtherSideOfLinks(result, options);
		}
		
		// Check whether classification records should be fetched.
		List<CerifEntity> classRecords = null;
		if (options.isClassificationRecordsIncluded()) {
			classRecords = retrieveClasses(result, linkFields, classRecords);
		}
		
		if (additionalEntities != null) {
			result.addAll(additionalEntities);
		}
		
		if (classRecords != null) {
			result.addAll(classRecords);
		}

		long end = System.currentTimeMillis();
		long duration = end - start;
		logger.info(duration);
		
		selectionResult.setEntities(result);
		selectionResult.setNumberOfElements(result.size());
		selectionResult.setOffset(options.getWindowOffset());
		selectionResult.setPageSize(options.getWindowSize());
		
		try {
			java.lang.Class<? extends CerifEntity> entityClass = options.getEntities().get(0).getEntityClass();
			selectionResult.setTotalNumberOfElements(countEntity(entityClass));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectionResult;		
	}

	private List<CerifEntity> retrieveClasses(List<CerifEntity> result, List<Field> linkFields, List<CerifEntity> classes) throws SelectionException {
		Set<Long> identifiers = new LinkedHashSet<Long>();
		
		try {
			for (CerifEntity entity : result) {
				for (Field field : linkFields) {
					Set<CerifLinkEntity> links = (Set<CerifLinkEntity>)new PropertyDescriptor(field.getName(), entity.getClass()).getReadMethod().invoke(entity);
					for (CerifLinkEntity link : links) {
						Object theClass = new PropertyDescriptor("theClass", link.getClass()).getReadMethod().invoke(link);
						Long id = (Long)theClass.getClass().getMethod(Utilities.getPrimaryKeyReadMethodName(theClass.getClass())).invoke(theClass);
						identifiers.add(id);
					}
				}				
			}
		} catch (Exception e) {
			logger.error("Error during retrieving classes. Options = [%s] ", e);
			throw new SelectionException(e.getMessage());
		}
		
		if (!identifiers.isEmpty()) {
			SelectionOptions op = new SelectionOptions();
			op.setFederatedIncluded(false);
			op.setLinksIncluded(false);
			op.setIdentifierList(new ArrayList<Object>(identifiers));
			classes = (List<CerifEntity>)retrieveEntities(Class.class, op, ClassEnum.CLASSIFICATION)[0];
		}
		return classes;
	}

	private Long countEntity(java.lang.Class<? extends CerifEntity> entityClass) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<? extends CerifEntity> root = query.from(entityClass);
		query.select(builder.count(root));
		return manager.createQuery(query).getSingleResult();
	}
	
	/**
	 * Whether the options contain an entity of the specified type.
	 * @param entity The entity classification type.
	 * @param options
	 * @return
	 */
	private boolean hasEntities(ClassEnum entity, SelectionOptions options) {
		return (options.getListOfEntitiesIncluded().contains(entity.getName()) || 
			   options.getListOfEntitiesIncluded().contains("all") || 
			   (options.getListOfEntitiesIncluded().isEmpty() && options.getEntities().isEmpty()) ||  //empty list equals to list with all or full list
			   options.getEntities().contains(entity)) && !options.getListOfEntitiesExcluded().contains(entity.getName());
	}
	
	/**
	 * Whether the options contain an embedded entity of the specified type.
	 * @param entity The entity classification type.
	 * @param options The selection options.
	 * @return false/true.
	 */
	private boolean hasEmbeddedEntities(ClassEnum entity, SelectionOptions options) {
		return options.getEmbeddedEntities().contains(entity);
	}

	/**
	 * Handles retrieval of an entity.
	 * @param options The selection options.
	 * @param entityClass The entity class.
	 * @return a list
	 * @throws SelectionException
	 */
	private <T, R> Object[] retrieveEntities(java.lang.Class<T> entityClass, SelectionOptions options, ClassEnum type) throws SelectionException {
		
		Object[] result = new Object[2];
		
		List<T> entities = null;	
		
		// basic fields
		entities = retrieveBasicFields(entityClass, options);
			
		List<Field> allLinkFields = new ArrayList<Field>();
		List<Field> multilingualFields = new ArrayList<Field>();
			
		for (T entity : entities) {
			//multilingual
			if (options.isMultilingualIncluded()) {
				try {
					List<Field> linkFields = ReflectionUtilities.getMultilingualFields(entityClass, entity);
					for (Field field : linkFields) {
						Set multilinguals = retrieveLinks(entity, field, entityClass);
						new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, multilinguals);
					}
				} catch (IllegalAccessException
						| IllegalArgumentException
						| InvocationTargetException
						| NoSuchMethodException
						| IntrospectionException e) {
					logger.error(String.format("Error during selection. Options = [%s] ", options), e);
					throw new SelectionException(e.getMessage());
				}
			}
			
			// links
			if (options.isLinksIncluded()) {
				try {
					List<Field> linkFields = ReflectionUtilities.getLinkFields(entityClass, options.getLinks(), entity);
					for (Field field : linkFields) {
						Set links = retrieveLinks(entity, field, entityClass);
						new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, links);
					}
					allLinkFields.addAll(linkFields);
				} catch (IllegalAccessException
						| IllegalArgumentException
						| InvocationTargetException
						| NoSuchMethodException
						| IntrospectionException e) {
					logger.error(String.format("Error during selection. Options = [%s] ", options), e);
					throw new SelectionException(e.getMessage());
				}
				
			} else {
				try {
					ReflectionUtilities.emptyLinks(entity);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException
						| IntrospectionException e) {
					logger.error(String.format("Error during selection. Options = [%s] ", options), e);
					throw new SelectionException(e.getMessage());
				}
			}
			
			// classifications
			try {
				if (options.isClassificationsIncluded()) {
					Field field = ReflectionUtilities.getClassField(entityClass);
					Set links = retrieveLinks(entity, field, entityClass);
					new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, links);
					allLinkFields.add(field);
					
				} else {
					ReflectionUtilities.emptyClassifications(entity);
				}
			} catch (IllegalAccessException
					| IllegalArgumentException
					| InvocationTargetException
					| NoSuchMethodException
					| IntrospectionException e) {
				logger.error(String.format("Error during selection. Options = [%s] ", options), e);
				throw new SelectionException(e.getMessage());
			}
			
		// federated identifiers
		try{
			if (options.isFederatedIncluded()) {
				List<FederatedIdentifier> federatedIdentifiers = secondService.getFederatedIdentifiersForEntity(type.getUuid(), (Long)entityClass.getMethod("getId").invoke(entity));
				entityClass.getMethod("setFederatedIdentifiers", List.class).invoke(entity, federatedIdentifiers);
			}
		} catch (IllegalAccessException
				| IllegalArgumentException
				| InvocationTargetException
				| NoSuchMethodException e) {
			logger.error(String.format("Error during selection. Options = [%s] ", options), e);
			throw new SelectionException(e.getMessage());
		}
			
		}
		
		result[0] = entities;
		result[1] = allLinkFields;
	
		return result;
	}

	/**
	 * Retrieves entities along with their basic and multilingual fields.
	 * @param entityClass The entity class.
	 * @param options The selection options.
	 * @return some entities.
	 */
	private <T> List<T> retrieveBasicAndMultilingualFields(java.lang.Class<T> entityClass, SelectionOptions options) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		
		final Field[] fields = entityClass.getDeclaredFields();
		logger.debug("entity: " + entityClass.getSimpleName());
		if (options.isMultilingualIncluded()) {
			if (entityClass.equals(Language.class)) {
				root.fetch("languageNames", JoinType.LEFT);
			} else {
				for (Field field : fields) {
					final String fieldName = field.getName();
					if (ReflectionUtilities.isMultilingualField(field)) {
						logger.debug("multi: " + fieldName);
						root.fetch(fieldName, JoinType.LEFT);
					}
				}
			}
		}

		if (options.isFindByCode()) {
			String code = (String)options.getId();
			query.select(root).where(builder.equal(root.get("code"), code)).distinct(true);
			
		} else if (options.isFindByUUID()) {
			String uuid = (String)options.getId();
			query.select(root).where(builder.equal(root.get("uuid"), uuid)).distinct(true);
			
		} else if (options.isFindById()) {
			Long id = Long.valueOf(options.getId().toString());
			query.select(root).where(builder.equal(root.get("id"), id)).distinct(true);
			
		} else if (options.isFindByMultipleIds()) {
			query.select(root).where(root.get("id").in(options.getIdentifierList())).distinct(true);
			
		} else {
			query.select(root).distinct(true);
		}

		//query.orderBy(builder.asc(root.get("id")));
		
		TypedQuery<T> typedQuery = manager.createQuery(query);
		if (options.getWindowSize() > 0) {
			typedQuery.setFirstResult(options.getWindowOffset());
			typedQuery.setMaxResults(options.getWindowSize());			
		}
		return typedQuery.getResultList();
	}
	
	/**
	 * Retrieves entities along with their basic.
	 * @param entityClass The entity class.
	 * @param options The selection options.
	 * @return some entities.
	 */
	private <T> List<T> retrieveBasicFields(java.lang.Class<T> entityClass, SelectionOptions options) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		
		if (options.isFindByCode()) {
			String code = (String)options.getId();
			query.select(root).where(builder.equal(root.get("code"), code)).distinct(true);
			
		} else if (options.isFindByUUID()) {
			String uuid = (String)options.getId();
			query.select(root).where(builder.equal(root.get("uuid"), uuid)).distinct(true);
			
		} else if (options.isFindById()) {
			Long id = Long.valueOf(options.getId().toString());
			query.select(root).where(builder.equal(root.get("id"), id)).distinct(true);
			
		} else if (options.isFindByMultipleIds()) {
			query.select(root).where(root.get("id").in(options.getIdentifierList())).distinct(true);
			
		} else {
			query.select(root).distinct(true);
		}

		//query.orderBy(builder.asc(root.get("id")));
		
		TypedQuery<T> typedQuery = manager.createQuery(query);
		
		if (options.getWindowSize() > 0) {
			typedQuery.setFirstResult(options.getWindowOffset());
			typedQuery.setMaxResults(options.getWindowSize());			
		}
		return typedQuery.getResultList();
	}
	
	/**
	 * Retrieves the links of the entity for the specified field. 
	 * @param entity The entity.
	 * @param field The linked field.
	 * @param entityClass The entity class.
	 * @return some links.
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws IntrospectionException
	 */
	private <T> Set retrieveLinks(T entity, Field field, java.lang.Class<T> entityClass)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, IntrospectionException {
		java.lang.Class<? extends CerifEntity> fieldClass = ReflectionUtilities.getTypeOfLinkField(field);
		Field theField = null;
		for (Field innerField : fieldClass.getDeclaredFields()) {
			if (innerField.getType().equals(entityClass)) {
				theField = innerField;
				break;
			}
		}
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery(fieldClass);
		Root root = query.from(fieldClass);
		
		Long id = (Long)entity.getClass().getMethod(Utilities.getPrimaryKeyReadMethodName(entityClass)).invoke(entity);
		query.select(root).where(builder.equal(root.get(theField.getName()).get(Utilities.getPrimaryKeyFieldName(entityClass)), id));
		
		TypedQuery typedQuery = manager.createQuery(query);
		List resultSet = typedQuery.getResultList();
		return new LinkedHashSet(resultSet);
	}
	
	/**
	 * Fetches entities from the other side of a link.
	 * @param result The result entities.
	 * @param options The selection options.
	 * @throws SelectionException
	 */
	private List<CerifEntity> retrieveEntitiesFromOtherSideOfLinks(List<CerifEntity> result, SelectionOptions options) throws SelectionException {

		List<CerifEntity> newEntities = new ArrayList<CerifEntity>();
		
		for (CerifEntity entity : result) {
			java.lang.Class<? extends CerifEntity> entityClass = entity.getClass();
			try {
				for (ClassEnum linkType : options.getLinkedObjects()) {
					java.lang.Class<? extends CerifEntity> linkClass = supportedEntities.get(linkType);
					final Field[] fields = entityClass.getDeclaredFields();
					for (Field field : fields) {
						if (ReflectionUtilities.isLinkField(field)) {
							java.lang.Class<? extends CerifEntity> fieldClass = ReflectionUtilities.getTypeOfLinkField(field);
							
							if (fieldClass.getSimpleName().contains(linkClass.getSimpleName())) {
								
								Field theField = null;
								for (Field innerField : fieldClass.getDeclaredFields()) {
									if (innerField.getType().equals(linkClass)) {
										theField = innerField;
									}
								}
						
								Collection<? extends CerifEntity> linkList = (Collection<? extends CerifEntity>) new PropertyDescriptor(field.getName(), entity.getClass()).getReadMethod().invoke(entity);
								if (!linkList.isEmpty()) {
									Iterator<? extends CerifEntity> iterator = linkList.iterator();
									while (iterator.hasNext()) {
										CerifEntity linkEntity = iterator.next();
										CerifEntity innerEntity = (CerifEntity) new PropertyDescriptor(theField.getName(), linkEntity.getClass()).getReadMethod().invoke(linkEntity);
										Long id = (Long)innerEntity.getClass().getMethod("getId").invoke(innerEntity);
										SelectionOptions newOptions = new SelectionOptions();
										newOptions.setLinksIncluded(false);
										newOptions.setMultilingualIncluded(true);
										newOptions.setFederatedIncluded(true);
										newOptions.setId(id);
										newEntities.addAll((Collection<? extends CerifEntity>)retrieveEntities(linkClass, newOptions, linkType)[0]);
									}
								}						
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("Error during handling entities from the other side of a link", e);
				throw new SelectionException(e.getMessage());
			}
		}
		return newEntities;
	}

}

