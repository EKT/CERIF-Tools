package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.second.SecondPersistenceService;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	public List<CerifEntity> select(SelectionOptions options) throws SelectionException {
		List<CerifEntity> result = new ArrayList<CerifEntity>();
		
		boolean links = options.isLinksIncluded();
		boolean showFedIds = options.isFederatedIncluded();
		
		long start = System.currentTimeMillis();	
		
		for (Entry<ClassEnum, java.lang.Class<? extends CerifEntity>> entry : supportedEntities.entrySet()) {
			ClassEnum enumeration = entry.getKey();
			if (!ClassEnum.CLASSIFICATION_SCHEME.equals(enumeration) && 
				!ClassEnum.CLASSIFICATION.equals(enumeration) &&
				hasEntities(enumeration, options)) {
				result.addAll(retrieveEntities(entry.getValue(), options, enumeration));
			}
		}
		
		if (hasEntities(ClassEnum.CLASSIFICATION, options)) {
			List<Class> classList = retrieveEntities(Class.class, options, ClassEnum.CLASSIFICATION);
			if (classList != null && !classList.isEmpty()) {
				for (Class classification : classList) {
					setClassInformation(classification);
					
					List<Class_Class> classClass1 = new ArrayList<Class_Class>();
					List<Class_Class> classClass2 = new ArrayList<Class_Class>();
					if (links) {
						//classes 1
						classClass1 = service.getLinkService().getClassClassRepository().findByTheClass2(classification);
						
						//classes 2
						classClass2 = service.getLinkService().getClassClassRepository().findByTheClass1(classification);
					}
					//classes 1
					Set<Class_Class> classes1 = new HashSet<Class_Class>(classClass1);
					classification.setClass_class1(classes1);
					
					//classes 2
					Set<Class_Class> classes2 = new HashSet<Class_Class>(classClass2);
					classification.setClass_class2(classes2);
													
					//FederatedIdentifiers
					if (showFedIds) {
						classification.setFederatedIdentifiers(service.getSecondService().getFederatedIdentifiersForEntity(ClassEnum.CLASSIFICATION.getUuid(), classification.getId()));
					}
									
					result.add(classification);
				}
			}
		}
		
		if (hasEntities(ClassEnum.CLASSIFICATION_SCHEME, options)) {
			List<ClassScheme> schemeList = retrieveEntities(ClassScheme.class, options, ClassEnum.CLASSIFICATION_SCHEME);
			if (schemeList != null && !schemeList.isEmpty()) {
				boolean embedClasses = hasEmbeddedEntities(ClassEnum.CLASSIFICATION, options);
				for (ClassScheme classScheme : schemeList) {
					if (embedClasses) {
						Set<Class> classes = new HashSet<Class>(service.getSemanticService().getClassRepository().findByScheme(classScheme));
						if (classes != null && !classes.isEmpty()) {
							for (Class theClass : classes) {
								setClassInformation(theClass);
							}
							classScheme.setClasses(classes);
						}
					} else {
						classScheme.setClasses(new HashSet<Class>());
					}
					
					result.add(classScheme);
				}
			}
			
		}
		
		if (hasEntities(ClassEnum.FEDERATED_IDENTIFIER, options)) {
			List<FederatedIdentifier> federatedList = retrieveEntities(FederatedIdentifier.class, options, ClassEnum.FEDERATED_IDENTIFIER);
			if (federatedList != null && !federatedList.isEmpty()) {
				for (FederatedIdentifier federatedIdentifier : federatedList) {
					List<FederatedIdentifier_Class> federatedIdentifierClasses = new ArrayList<FederatedIdentifier_Class>();
					List<Service_FederatedIdentifier> federatedIdentifierServices = new ArrayList<Service_FederatedIdentifier>();
					if (links) {
						//classes
						federatedIdentifierClasses = service.getLinkService().getFederatedIdentifierClassRepository().findByFederatedIdentifier(federatedIdentifier);
						
						//services
						federatedIdentifierServices = service.getLinkService().getServiceFederatedIdentifierRepository().findByFederatedIdentifier(federatedIdentifier);
					}
					//classes
					Set<FederatedIdentifier_Class> classes = new HashSet<FederatedIdentifier_Class>(federatedIdentifierClasses);
					federatedIdentifier.setFederatedIdentifiers_classes(classes);
					
					//services
					Set<Service_FederatedIdentifier> services = new HashSet<Service_FederatedIdentifier>(federatedIdentifierServices);
					federatedIdentifier.setServices_federatedIdentifiers(services);
					
					result.add(federatedIdentifier);
				}
			}
		}

		// Check whether entities, from the other side of some links, should be fetched.
		if (options.isSingleEntity() && !options.getLinkEntities().isEmpty() && !result.isEmpty()) {
			retrieveEntitiesFromOtherSideOfLinks(result, options);
		}

		long end = System.currentTimeMillis();
		long duration = end - start;
		logger.info(duration);
		
		return result;		
	}


	
	/**
	 * Sets the classification information.
	 * @param classification The classification.
	 */
	private void setClassInformation(Class classification) {
		//descriptions
		List<ClassDescription> classDescriptions = service.getTranslationService().getClassDescriptionRepository().findByTheClass(classification);
		Set<ClassDescription> descriptions = new HashSet<ClassDescription>(classDescriptions);
		classification.setClassDescriptions(descriptions);
		
		//terms
		List<ClassTerm> classTerms = service.getTranslationService().getClassTermRepository().findByTheClass(classification);
		Set<ClassTerm> terms = new HashSet<ClassTerm>(classTerms);
		classification.setClassTerms(terms);
		
		//definitions
		List<ClassDefinition> classDefinitions = service.getTranslationService().getClassDefinitionRepository().findByTheClass(classification);
		Set<ClassDefinition> definitions = new HashSet<ClassDefinition>(classDefinitions);
		classification.setClassDefinitions(definitions);
		
		//ex
		List<ClassEx> classExs = service.getTranslationService().getClassExRepository().findByTheClass(classification);
		Set<ClassEx> examples = new HashSet<ClassEx>(classExs);
		classification.setClassExs(examples);
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
	private <T, R> List<T> retrieveEntities(java.lang.Class<T> entityClass, SelectionOptions options, ClassEnum type) throws SelectionException {
		List<T> result = null;	
		
		try {
			// basic and multilingual fields
			result = retrieveBasicAndMultilingualFields(entityClass, options);
			
			for (T entity : result) {
				// links
				if (options.isLinksIncluded()) {
					List<Field> linkFields = getLinkFields(entityClass);
					for (Field field : linkFields) {
						Set links = retrieveLinks(entity, field, entityClass);
						new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, links);
					}
					
				} else {
					emptyLinks(entity);
				}
				
				// federated identifiers
				if (options.isFederatedIncluded()) {
					List<FederatedIdentifier> federatedIdentifiers = secondService.getFederatedIdentifiersForEntity(type.getUuid(), (Long)entityClass.getMethod("getId").invoke(entity));
					entityClass.getMethod("setFederatedIdentifiers", List.class).invoke(entity, federatedIdentifiers);
				}				
			}
			
		} catch (Exception e) {
			logger.error(String.format("Error during selection. Options = [%s] ", options), e);
			throw new SelectionException(e.getMessage());
		}
		
		return result;
	}

	/**
	 * Gets, via reflection, the fields which refer to linked entities.
	 * @param entityClass The entity class.
	 * @return some fields
	 */
	private <T> List<Field> getLinkFields(java.lang.Class<T> entityClass) {
		final List<Field> result = new ArrayList<Field>();
		final Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			if (isLinkField(field)) {
				logger.debug("link: " + field.getName());
				result.add(field);
			}
		}
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
					if (isMultilingualField(field)) {
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
			
		} else {
			query.select(root).distinct(true);
		}
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
		java.lang.Class<? extends CerifEntity> fieldClass = getTypeOfLinkField(field);
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
	 * Checks whether the provided field is a multilingual one.
	 * @param entityName The entity name.
	 * @param fieldName The field name.
	 * @return false/true.
	 */
	@SuppressWarnings("rawtypes")
	private boolean isMultilingualField(Field field) {
		Type type = field.getGenericType();
		return type instanceof ParameterizedType && CerifMultipleLanguageFeature.class.isAssignableFrom((java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0]);
	}
	
	/**
	 * Checks whether the provided field is a linked one.
	 * @param entityName The entity name.
	 * @param fieldName The field name.
	 * @return false/true.
	 */
	@SuppressWarnings("rawtypes")
	private static boolean isLinkField(Field field) {
		Type type = field.getGenericType();
		return type instanceof ParameterizedType && CerifLinkEntity.class.isAssignableFrom((java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0]);
	}
	
	/**
	 * Extracts the actual type of a linked field.
	 * @param field The field
	 * @return a type.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private java.lang.Class<? extends CerifEntity> getTypeOfLinkField(Field field) {
		Type type = field.getGenericType();
		return (java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0];
	}
	
	/**
	 * Sets empty collections to the linked fields of the entity.
	 * @param entity The CERIF entity.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	private void emptyLinks(Object entity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (isLinkField(field)) {
				new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, Collections.emptySet());
			}
		}
	}
	
	/**
	 * Fetches entities from the other side of a link.
	 * @param result The result entities.
	 * @param options The selection options.
	 * @throws SelectionException
	 */
	private void retrieveEntitiesFromOtherSideOfLinks(List<CerifEntity> result, SelectionOptions options) throws SelectionException {
		CerifEntity entity = result.get(0);
		java.lang.Class<? extends CerifEntity> entityClass = entity.getClass();
		
		try {
			for (ClassEnum linkType : options.getLinkEntities()) {
				java.lang.Class<? extends CerifEntity> linkClass = supportedEntities.get(linkType);
				final Field[] fields = entityClass.getDeclaredFields();
				for (Field field : fields) {
					if (isLinkField(field)) {
						java.lang.Class<? extends CerifEntity> fieldClass = getTypeOfLinkField(field);
						
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
									result.addAll(retrieveEntities(linkClass, newOptions, linkType));
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

}

