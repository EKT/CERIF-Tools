/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifComponent;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

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
}
