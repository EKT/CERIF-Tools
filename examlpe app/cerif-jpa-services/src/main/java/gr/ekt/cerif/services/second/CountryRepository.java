/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.second.Country;

/**
 * A repository for countries.
 * 
 */
public interface CountryRepository {

	Country findByCode(String code);
	
	Country findByUri(String uri);
	
	List<Country> findAll();
	
	public void delete(Country entity); 
	
	public void delete(Iterable<Country> entities); 

	public Iterable<Country> save(Iterable<Country> entities); 
	
	public Country save(Country entity);
		
}
