package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.person.Person_Service;

/**
 * A repository for links between persons and services.
 * 
 */
public interface LinkPersonServiceRepository {

	public void delete(Person_Service entity); 
	
	public void delete(Iterable<Person_Service> entities); 

	public Iterable<Person_Service> save(Iterable<Person_Service> entities); 
	
	public Person_Service save(Person_Service entity);
	
	List<Person_Service> findByService(Service service);
	
	List<Person_Service> findByPerson(Person person);
	
}
