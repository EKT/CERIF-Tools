/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifComponent;
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
	 * @TODO FOR EVERY ENTITY IMPLEMENT DELETE
	 * @param component The CERIF component.
	 */
	public void delete(CerifComponent component){
		if (component == null) {
			throw new IllegalArgumentException("Empty component provided. Save will not proceed.");
		}
		
		if (component instanceof CerifBaseEntity) {
			baseService.delete((CerifBaseEntity) component);
		} 
		else if (component instanceof CerifResultEntity) {
			resultService.delete((CerifResultEntity) component);
		}
		else if (component instanceof CerifLinkEntity) {
			linkService.delete((CerifLinkEntity) component);
		} 
		else if (component instanceof CerifSecondLevelEntity) {
			secondService.delete((CerifSecondLevelEntity) component);
		} 
//			else if (component instanceof CerifInfrastructureEntity) {
//			infrastructureService.delete((CerifInfrastructureEntity) component);
//		} 
		else if (component instanceof CerifMultipleLanguageFeature) {
			translationService.delete( (CerifMultipleLanguageFeature) component);
	} 
			else if (component instanceof CerifSemanticFeature) {
			semanticService.delete((CerifSemanticFeature) component);
		} 
		else if (component instanceof CerifAdditionalFeature) {
			additionalService.delete((CerifAdditionalFeature) component);
		}
	}
	
	@Override
	public void save(CerifComponent component) {
		
		if (component == null) {
			throw new IllegalArgumentException("Empty component provided. Save will not proceed.");
		}
		
		if (component instanceof CerifBaseEntity) {
			baseService.save((CerifBaseEntity) component);
		} else if (component instanceof CerifResultEntity) {
			resultService.save((CerifResultEntity) component);
		} else if (component instanceof CerifLinkEntity) {
			linkService.save((CerifLinkEntity) component);
		} else if (component instanceof CerifSecondLevelEntity) {
			secondService.save((CerifSecondLevelEntity) component);
		} else if (component instanceof CerifInfrastructureEntity) {
			infrastructureService.save((CerifInfrastructureEntity) component);
		} else if (component instanceof CerifMultipleLanguageFeature) {
			translationService.save( (CerifMultipleLanguageFeature) component);
		} else if (component instanceof CerifSemanticFeature) {
			semanticService.save((CerifSemanticFeature) component);
		} else if (component instanceof CerifAdditionalFeature) {
			additionalService.save((CerifAdditionalFeature) component);
		}
		
	}
	
	/**
	 * Deletes the provided CERIF components.
	 * @param components The CERIF components.
	 */
	@SuppressWarnings("unchecked")
	public void delete(List<? extends CerifComponent> components) {
		
		if (components == null || components.size() == 0) {
			throw new IllegalArgumentException("Empty collection provided. Save will not proceed.");
		}
		
		final CerifComponent type = components.get(0);
		
		if (type instanceof CerifLinkEntity) {
			linkService.delete((List<CerifLinkEntity>) components);
		}
	}

	/**
	 * Saves the provided CERIF components.
	 * @param components The CERIF components.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save(List<? extends CerifComponent> components) {
		
		if (components == null || components.size() == 0) {
			throw new IllegalArgumentException("Empty collection provided. Save will not proceed.");
		}
		
		final CerifComponent type = components.get(0);
		
		if (type instanceof CerifBaseEntity) {
			baseService.save((List<CerifBaseEntity>) components);
		} else if (type instanceof CerifResultEntity) {
			resultService.save((List<CerifResultEntity>) components);
		} else if (type instanceof CerifLinkEntity) {
			linkService.save((List<CerifLinkEntity>) components);
		} else if (type instanceof CerifSecondLevelEntity) {
			secondService.save((List<CerifSecondLevelEntity>) components);
		} else if (type instanceof CerifInfrastructureEntity) {
			infrastructureService.save((List<CerifInfrastructureEntity>) components);
		} else if (type instanceof CerifMultipleLanguageFeature) {
			
		} else if (type instanceof CerifSemanticFeature) {
			semanticService.save((List<CerifSemanticFeature>) components);
		} else if (type instanceof CerifAdditionalFeature) {

		}
		
		
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
