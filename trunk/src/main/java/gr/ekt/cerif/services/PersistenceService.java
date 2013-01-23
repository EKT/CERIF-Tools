/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.services.additional.AdditionalPersistenceService;
import gr.ekt.cerif.services.base.BasePersistenceService;
import gr.ekt.cerif.services.infrastructure.InfrastructurePersistenceService;
import gr.ekt.cerif.services.link.LinkPersistenceService;
import gr.ekt.cerif.services.multilingual.TranslationPersistenceService;
import gr.ekt.cerif.services.result.ResultPersistenceService;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.SemanticsPersistenceService;

/**
 * Persistence service for CERIF entities.
 * 
 */
public interface PersistenceService {

	/**
	 * Saves the provided CERIF entity.
	 * @param entity The CERIF entity.
	 */
	CerifEntity save(CerifEntity entity);	
	
	/**
	 * Saves the provided CERIF entities.
	 * @param entities The CERIF components.
	 */
	Iterable<? extends CerifEntity> save(Iterable<? extends CerifEntity> entities);
	
	void delete(CerifEntity entity);
	
	void delete(Iterable<? extends CerifEntity> entities);
	
	BasePersistenceService getBaseService();
	
	ResultPersistenceService getResultService();
		
	SecondPersistenceService getSecondService();
	
	InfrastructurePersistenceService getInfrastructureService();
	
	SemanticsPersistenceService getSemanticService();

	LinkPersistenceService getLinkService();
	
	TranslationPersistenceService getTranslationService();
	
	AdditionalPersistenceService getAdditionalService();
}
