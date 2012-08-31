/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifComponent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.services.additional.AdditionalPersistenceService;
import gr.ekt.cerif.services.base.BasePersistenceService;
import gr.ekt.cerif.services.infrastructure.InfrastructurePersistenceService;
import gr.ekt.cerif.services.link.LinkPersistenceService;
import gr.ekt.cerif.services.multilingual.TranslationPersistenceService;
import gr.ekt.cerif.services.result.ResultPersistenceService;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.SemanticsPersistenceService;

import java.util.List;
import java.util.Set;

/**
 * Persistence service for CERIF entities.
 * 
 */
public interface PersistenceService {

	/**
	 * Saves the provided CERIF component.
	 * @param component The CERIF component.
	 */
	void save(CerifComponent component);	
	
	/**
	 * Saves the provided CERIF components.
	 * @param components The CERIF components.
	 */
	void save(List<? extends CerifComponent> components);
	
	
	void delete(CerifComponent component);
	
	void delete(List<? extends CerifComponent> components);	
		
	BasePersistenceService getBaseService();
	
	ResultPersistenceService getResultService();
		
	SecondPersistenceService getSecondService();
	
	InfrastructurePersistenceService getInfrastructureService();
	
	SemanticsPersistenceService getSemanticService();

	LinkPersistenceService getLinkService();
	
	TranslationPersistenceService getTranslationService();
	
	AdditionalPersistenceService getAdditionalService();
}
