package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.second.Event;

/**
 * A repository for links between persons and events.
 * 
 */
public interface LinkPersonEventRepository {

	public void delete(Person_Event entity); 
	
	public void delete(Iterable<Person_Event> entities); 

	public Iterable<Person_Event> save(Iterable<Person_Event> entities); 
	
	public Person_Event save(Person_Event entity);
	
	List<Person_Event> findByPerson(Person person);
	
	List<Person_Event> findByEvent(Event event);
	
}
