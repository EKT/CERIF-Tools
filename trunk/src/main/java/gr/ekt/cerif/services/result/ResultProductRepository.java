/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

/**
 * A repository for products.
 * 
 */
public interface ResultProductRepository {

	/**
	 * Saves the provided result product.
	 * @param resultProduct
	 */
	void save(ResultProduct resultProduct);

	/**
	 * Saves the provided list of result products.
	 * @param productList
	 */
	void save(List<ResultProduct> productList);
	
	
	List<ResultProduct> getAllProducts();
	
	ResultProduct getProduct(Long id);
	
	List<ResultProduct> findByKeyword(String keyword);
	
	List<ResultProduct> findByClass(String uri);
	
	List<ResultProduct> findByOrganisationClass(String uri);

	List<ResultProduct> findByPersonClass(String uri);
	
	List<ResultProduct> findByCountry(String code);

	List<ResultProduct> findByProjectClass(String uri);

	List<ResultProduct> findByOrganisationURI(String uri);

	List<ResultProduct> findByPersonComplete(String input);

	List<ResultProduct> findByOrganisationURIClass(String orgURI, String classURI);

	List<ResultProduct> findByOrganisationExpanded(String input, String classURI);
	
}
