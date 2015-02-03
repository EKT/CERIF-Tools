package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Country;

/**
 * A repository for links between persons and countries.
 * 
 */
public interface LinkPersonCountryRepository {

	public void delete(Person_Country entity); 
	
	public void delete(Iterable<Person_Country> entities); 

	public Iterable<Person_Country> save(Iterable<Person_Country> entities); 
	
	public Person_Country save(Person_Country entity);
	
	List <Person_Country> findByPerson(Person person);
	
}
