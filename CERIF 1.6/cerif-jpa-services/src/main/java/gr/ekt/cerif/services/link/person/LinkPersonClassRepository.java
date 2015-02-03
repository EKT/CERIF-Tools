package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between persons and classes.
 * 
 */

public interface LinkPersonClassRepository {

	List <Person_Class> findByPerson(Person person);
	
	Person_Class save(Person_Class entity);
	
	Iterable<Person_Class> save(Iterable<Person_Class> entityList);
	
	void delete(Person_Class entity);
	
	void delete(Iterable<Person_Class> entityList);
	
	Person_Class findByPersonAndTheClass(Person person, Class theClass);
	
}
