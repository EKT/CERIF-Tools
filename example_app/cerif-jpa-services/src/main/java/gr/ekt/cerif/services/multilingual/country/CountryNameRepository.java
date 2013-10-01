/**
 * 
 */
package gr.ekt.cerif.services.multilingual.country;

import gr.ekt.cerif.features.multilingual.CountryName;

/**
 * @author bonisv
 *
 */
public interface CountryNameRepository {
	
	CountryName findByName(String name);

	public void delete(CountryName entity); 
	
	public void delete(Iterable<CountryName> entities); 

	public Iterable<CountryName> save(Iterable<CountryName> entities); 
	
	public CountryName save(CountryName entity);
}
