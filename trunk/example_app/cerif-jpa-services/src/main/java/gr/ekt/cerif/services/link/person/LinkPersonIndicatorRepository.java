package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Indicator;

/**
 * A repository for links between persons and indicators.
 * 
 */
public interface LinkPersonIndicatorRepository {

	public void delete(Person_Indicator entity); 
	
	public void delete(Iterable<Person_Indicator> entities); 

	public Iterable<Person_Indicator> save(Iterable<Person_Indicator> entities); 
	
	public Person_Indicator save(Person_Indicator entity);
	
}
