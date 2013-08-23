package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Event;

/**
 * A repository for links between persons and events.
 * 
 */
public interface LinkPersonEventRepository {

	public void delete(Person_Event entity); 
	
	public void delete(Iterable<Person_Event> entities); 

	public Iterable<Person_Event> save(Iterable<Person_Event> entities); 
	
	public Person_Event save(Person_Event entity);
	
}
