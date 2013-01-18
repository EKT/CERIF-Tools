/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.services.additional.AdditionalPersistenceService;
import gr.ekt.cerif.services.base.BasePersistenceService;
import gr.ekt.cerif.services.infrastructure.InfrastructurePersistenceService;
import gr.ekt.cerif.services.link.LinkPersistenceService;
import gr.ekt.cerif.services.multilingual.TranslationPersistenceService;
import gr.ekt.cerif.services.result.ResultPersistenceService;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.SemanticsPersistenceService;

import java.util.List;

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
	
	List<ResultProduct> getAllProducts();
	
	ResultProduct getProduct(Long id);
	
	List<ResultProduct> getProductsByKeyword(String keyword);
	
	List<ResultProduct> getProductsByClass(String uri);
	
	List<ResultProduct> getProductByOrganisationClass(String uri);
	
	List<ResultProduct> getProductByPersonClass(String uri);
	
	List<ResultProduct> getProductByProjectClass(String uri);
	
	List<ResultProduct> getProductByCountry(String code);

	List<ResultProduct> getProductByOrganisationURI(String uri);

	List<ResultProduct> getProductByPersonAny(String uri);

	List<ResultProduct> getProductByOrganisationURIClass(String orgURI, String classURI);

	List<ResultProduct> getProductByOrganisationExpanded(String input, String classURI);
		
	BasePersistenceService getBaseService();
	
	ResultPersistenceService getResultService();
		
	SecondPersistenceService getSecondService();
	
	InfrastructurePersistenceService getInfrastructureService();
	
	SemanticsPersistenceService getSemanticService();

	LinkPersistenceService getLinkService();
	
	TranslationPersistenceService getTranslationService();
	
	AdditionalPersistenceService getAdditionalService();
}
