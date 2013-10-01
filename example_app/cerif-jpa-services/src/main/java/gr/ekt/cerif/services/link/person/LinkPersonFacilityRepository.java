package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Facility;

/**
 * A repository for links between persons and facilities.
 * 
 */
public interface LinkPersonFacilityRepository {

	public void delete(Person_Facility entity); 
	
	public void delete(Iterable<Person_Facility> entities); 

	public Iterable<Person_Facility> save(Iterable<Person_Facility> entities); 
	
	public Person_Facility save(Person_Facility entity);
	
}
