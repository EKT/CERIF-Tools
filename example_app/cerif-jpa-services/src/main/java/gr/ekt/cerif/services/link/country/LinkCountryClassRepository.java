package gr.ekt.cerif.services.link.country;

import gr.ekt.cerif.entities.link.Country_Class;

/**
 * A repository for links between countries and classes.
* 
*/
public interface LinkCountryClassRepository {

	public void delete(Country_Class entity); 
	
	public void delete(Iterable<Country_Class> entities); 

	public Iterable<Country_Class> save(Iterable<Country_Class> entities); 
	
	public Country_Class save(Country_Class entity);
	
}
