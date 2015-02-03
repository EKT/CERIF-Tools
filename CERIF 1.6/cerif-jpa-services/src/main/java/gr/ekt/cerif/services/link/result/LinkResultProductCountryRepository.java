package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Country;

/**
 * A repository for links between resultProducts and countries.
 * 
 */
public interface LinkResultProductCountryRepository {

	public void delete(ResultProduct_Country entity); 
	
	public void delete(Iterable<ResultProduct_Country> entities); 

	public Iterable<ResultProduct_Country> save(Iterable<ResultProduct_Country> entities); 
	
	public ResultProduct_Country save(ResultProduct_Country entity);
	
	List<ResultProduct_Country> findByCountry(Country country);
	
	List<ResultProduct_Country> findByResultProduct(ResultProduct resultProduct);
	
}
