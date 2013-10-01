/**
 * 
 */
package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Country;

/**
 * A repository for links between classes and products.
 * 
 */
public interface LinkProductCountryRepository {
	
	public void delete(ResultProduct_Country entity); 
	
	public void delete(Iterable<ResultProduct_Country> entities); 

	public Iterable<ResultProduct_Country> save(Iterable<ResultProduct_Country> entities); 
	
	public ResultProduct_Country save(ResultProduct_Country entity);

}
