/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.semantics.CerifSemanticFeature;
import gr.ekt.cerif.services.additional.AdditionalPersistenceService;
import gr.ekt.cerif.services.base.BasePersistenceService;
import gr.ekt.cerif.services.infrastructure.InfrastructurePersistenceService;
import gr.ekt.cerif.services.link.LinkPersistenceService;
import gr.ekt.cerif.services.multilingual.TranslationPersistenceService;
import gr.ekt.cerif.services.result.ResultPersistenceService;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.SemanticsPersistenceService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the persistence service for CERIF entities.
 * 
 */
@Component
public class PersistenceServiceImpl implements PersistenceService {
	
	/**
	 * Service for persisting base entities.
	 */
	@Autowired
	private BasePersistenceService baseService;

	/**
	 * Service for persisting result entities.
	 */
	@Autowired
	private ResultPersistenceService resultService;
	
	/**
	 * Service for persisting 2nd level entities.
	 */
	@Autowired
	private SecondPersistenceService secondService;
	
	/**
	 * Service for persisting infrastructure entities.
	 */
	@Autowired
	private InfrastructurePersistenceService infrastructureService;
	
	/**
	 * Service for persisting semantics features.
	 */
	@Autowired
	private SemanticsPersistenceService semanticService;
	
	/**
	 * Service for persisting link entities.
	 */
	@Autowired
	private LinkPersistenceService linkService;
	
	/**
	 * Service for persisting translation feature entities.
	 */
	@Autowired
	private TranslationPersistenceService translationService;
	
	/**
	 * Service for persisting translation feature entities.
	 */
	@Autowired
	private AdditionalPersistenceService additionalService;
	
	@Autowired
	private GenericQuery genericQuery;
	
	@Autowired
	private SelectionService selectionService;
	
	@Autowired
	private ApplicationContext context;
	
	/**
	 * Logging facility.
	 */
	private static final Logger logger = Logger.getLogger(PersistenceServiceImpl.class);

	
	/**
	 * Deletes the provided CERIF record.
	 * @param component The CERIF record.
	 */
	@Override
	@Transactional
	public void delete(CerifEntity entity){
		if (entity == null) {
			throw new IllegalArgumentException("Empty entity provided. Save will not proceed.");
		}
		
		Object ob;
		
		if (entity instanceof CerifLinkEntity || entity instanceof CerifMultipleLanguageFeature 
				|| entity instanceof Country || entity instanceof Currency || entity instanceof Language 
				|| entity instanceof CerifSemanticFeature) {
			String className = null;
			className = entity.getClass().getSimpleName();
			String beanName = "";
		
			if (entity instanceof CerifLinkEntity) {
				beanName = "link" + className.replaceAll("_", "") + "RepositoryImpl";
			} else {
				beanName = className.substring(0, 1).toLowerCase() + className.substring(1) + "RepositoryImpl";
			}
			
			Object genericRepository = context.getBean(beanName);
		
			ob = executeGenericMethod("delete", genericRepository, entity);			
		} else {
			String findByEntityMethodName;
			String beanName;
			String className;
			Object genericRepository;
			
			final Field[] fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.getName().indexOf("1") != -1) {
					findByEntityMethodName = "findBy" + entity.getClass().getSimpleName()+"1";
				} else if (field.getName().indexOf("2") != -1) {
					findByEntityMethodName = "findBy" + entity.getClass().getSimpleName()+"2";
				} else {
					findByEntityMethodName = "findBy" + entity.getClass().getSimpleName();
				}
				
				Type type = field.getGenericType();
				if (type instanceof ParameterizedType) {
					String typeName = ((ParameterizedType)type).getActualTypeArguments()[0].toString();
					className = typeName.substring(typeName.lastIndexOf(".")+1);
					
					if (className.indexOf("_") != -1) {
						beanName = "link" + className.replaceAll("_", "") + "RepositoryImpl";
					} else {
						beanName = className.substring(0, 1).toLowerCase() + className.substring(1) + "RepositoryImpl";
					}
				
					genericRepository = context.getBean(beanName);
				
					ob = executeGenericMethod(findByEntityMethodName, genericRepository, entity);
					List<CerifEntity> result = (List<CerifEntity>)ob;
					
					if (!result.isEmpty()) {
						for (CerifEntity cf: result) {
							delete(cf);
						}
					}
				}
			}
			
			className = entity.getClass().getSimpleName();
			beanName = className.substring(0, 1).toLowerCase() + className.substring(1) + "RepositoryImpl";
			genericRepository = context.getBean(beanName);
		
			ob = executeGenericMethod("delete", genericRepository, entity);			
		}
	}
	
	
	/**
	 * Saves a CERIF record.
	 * @param entity The CERIF record.
	 * @return entity The CERIF record.
	 */
	@Override
	@Transactional
	public <T extends CerifEntity> T save(T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Empty component provided. Save will not proceed.");
		}
		
		String className = entity.getClass().getSimpleName();
		String beanName = "";
		
		if (entity instanceof CerifLinkEntity) {
			beanName = "link" + className.replaceAll("_", "") + "RepositoryImpl";
		} else {
			beanName = className.substring(0, 1).toLowerCase() + className.substring(1) + "RepositoryImpl";
		}
		
		Object genericRepository = context.getBean(beanName);
		
		Object ob = executeGenericMethod("save", genericRepository, entity);
		entity = (T)ob;
		
		return entity;
	}
	
	
	/**
	 * Deletes the provided CERIF records.
	 * @param components The CERIF records.
	 */
	@Override
	@Transactional
	public void delete(Collection<? extends CerifEntity> entities) {
		
		if (entities == null || !entities.iterator().hasNext()) {
			throw new IllegalArgumentException("Empty collection provided. Delete will not proceed.");
		}
		
		for (CerifEntity cf: entities) {
			delete(cf);
		}
	}

	
	/**
	 * Saves the provided CERIF records.
	 * @param entities The CERIF records.
	 */
	@Override
	@Transactional
	public Collection<? extends CerifEntity> save(Collection<? extends CerifEntity> entities) {
		
		if (entities == null || !entities.iterator().hasNext()) {
			throw new IllegalArgumentException("Empty collection provided. Save will not proceed.");
		}
		
		for (CerifEntity cf: entities) {
			save(cf);
		}

		return entities;
	}
	
	
	/**
	 * @return the baseService
	 */
	public BasePersistenceService getBaseService() {
		return baseService;
	}

	/**
	 * @return the resultService
	 */
	public ResultPersistenceService getResultService() {
		return resultService;
	}

	/**
	 * @return the secondService
	 */
	public SecondPersistenceService getSecondService() {
		return secondService;
	}

	/**
	 * @return the infrastructureService
	 */
	public InfrastructurePersistenceService getInfrastructureService() {
		return infrastructureService;
	}

	/**
	 * @return the semanticService
	 */
	public SemanticsPersistenceService getSemanticService() {
		return semanticService;
	}

	/**
	 * @return the linkService
	 */
	public LinkPersistenceService getLinkService() {
		return linkService;
	}

	/**
	 * @return the translationService
	 */
	public TranslationPersistenceService getTranslationService() {
		return translationService;
	}

	/**
	 * @return the additionalService
	 */
	public AdditionalPersistenceService getAdditionalService() {
		return additionalService;
	}

	/**
	 * @return the genericQuery
	 */
	public GenericQuery getGenericQuery() {
		return genericQuery;
	}

	/**
	 * @return the selectionService
	 */
	public SelectionService getSelectionService() {
		return selectionService;
	}
	
	
	/**
	 * Calls a method.
	 * @param methodName The method's name.
	 * @param genericRepository The Repository object that holds the method.
	 * @param entity The CERIF record that is used as parameter in the method.
	 * @return ob.
	 */
	private <T> Object executeGenericMethod(String methodName, Object genericRepository, T entity) {
		Object ob = null;
		try {
			ob = genericRepository.getClass()
					.getMethod(methodName, entity.getClass())
					.invoke(genericRepository, entity);
			
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return ob;
	}
}
