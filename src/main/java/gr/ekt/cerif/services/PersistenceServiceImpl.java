/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.CerifBaseEntity;
import gr.ekt.cerif.entities.infrastructure.CerifInfrastructureEntity;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.CerifResultEntity;
import gr.ekt.cerif.entities.second.CerifSecondLevelEntity;
import gr.ekt.cerif.features.additional.CerifAdditionalFeature;
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/**
	 * Deletes the provided CERIF component.
	 * @param component The CERIF component.
	 */
	@Transactional
	public void delete(CerifEntity entity){
		if (entity == null) {
			throw new IllegalArgumentException("Empty entity provided. Save will not proceed.");
		}
		
		if (entity instanceof CerifBaseEntity) {
			baseService.delete((CerifBaseEntity) entity);
		} 
		else if (entity instanceof CerifResultEntity) {
			resultService.delete((CerifResultEntity) entity);
		}
		else if (entity instanceof CerifLinkEntity) {
			linkService.delete((CerifLinkEntity) entity);
		} 
		else if (entity instanceof CerifSecondLevelEntity) {
			secondService.delete((CerifSecondLevelEntity) entity);
		} 
//			else if (component instanceof CerifInfrastructureEntity) {
//			infrastructureService.delete((CerifInfrastructureEntity) component);
//		} 
		else if (entity instanceof CerifMultipleLanguageFeature) {
			translationService.delete( (CerifMultipleLanguageFeature) entity);
	} 
			else if (entity instanceof CerifSemanticFeature) {
			semanticService.delete((CerifSemanticFeature) entity);
		} 
		else if (entity instanceof CerifAdditionalFeature) {
			additionalService.delete((CerifAdditionalFeature) entity);
		}
	}
	
	@Override
	@Transactional
	public CerifEntity save(CerifEntity entity) {
		
		if (entity == null) {
			throw new IllegalArgumentException("Empty component provided. Save will not proceed.");
		}
		
		if (entity instanceof CerifBaseEntity) {
			entity = baseService.save((CerifBaseEntity) entity);
		} else if (entity instanceof CerifResultEntity) {
			entity = resultService.save((CerifResultEntity) entity);
		} else if (entity instanceof CerifLinkEntity) {
			entity = linkService.save((CerifLinkEntity) entity);
		} else if (entity instanceof CerifSecondLevelEntity) {
			entity = secondService.save((CerifSecondLevelEntity) entity);
		} else if (entity instanceof CerifInfrastructureEntity) {
			entity = infrastructureService.save((CerifInfrastructureEntity) entity);
		} else if (entity instanceof CerifMultipleLanguageFeature) {
			entity = translationService.save((CerifMultipleLanguageFeature) entity);
		} else if (entity instanceof CerifSemanticFeature) {
			entity = semanticService.save((CerifSemanticFeature) entity);
		} else if (entity instanceof CerifAdditionalFeature) {
			entity = additionalService.save((CerifAdditionalFeature) entity);
		}
		
		return entity;
	}
	
	/**
	 * Deletes the provided CERIF components.
	 * @param components The CERIF components.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void delete(Iterable<? extends CerifEntity> entities) {
		
		if (entities == null || !entities.iterator().hasNext()) {
			throw new IllegalArgumentException("Empty collection provided. Save will not proceed.");
		}
		
		final CerifEntity type = entities.iterator().next();
		
		if (type instanceof CerifLinkEntity) {
			linkService.delete((List<CerifLinkEntity>) entities);
		}
	}

	/**
	 * Saves the provided CERIF entities.
	 * @param entities The CERIF entities.
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Iterable<? extends CerifEntity> save(Iterable<? extends CerifEntity> entities) {
		
		if (entities == null || !entities.iterator().hasNext()) {
			throw new IllegalArgumentException("Empty collection provided. Save will not proceed.");
		}
		
		final CerifEntity type = entities.iterator().next();
		
		if (type instanceof CerifBaseEntity) {
			entities = baseService.save((Iterable<CerifBaseEntity>) entities);
		} else if (type instanceof CerifResultEntity) {
			entities = resultService.save((Iterable<CerifResultEntity>) entities);
		} else if (type instanceof CerifLinkEntity) {
			entities = linkService.save((Iterable<CerifLinkEntity>) entities);
		} else if (type instanceof CerifSecondLevelEntity) {
			entities = secondService.save((Iterable<CerifSecondLevelEntity>) entities);
		} else if (type instanceof CerifInfrastructureEntity) {
			entities = infrastructureService.save((Iterable<CerifInfrastructureEntity>) entities);
		} else if (type instanceof CerifMultipleLanguageFeature) {
			
		} else if (type instanceof CerifSemanticFeature) {
			entities = semanticService.save((Iterable<CerifSemanticFeature>) entities);
		} else if (type instanceof CerifAdditionalFeature) {

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
	
}
