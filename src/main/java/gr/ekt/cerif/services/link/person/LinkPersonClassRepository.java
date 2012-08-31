package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between persons and classes.
 * 
 */

public interface LinkPersonClassRepository  extends CrudRepository<Person_Class, Long>{
	
	List <Person_Class> findByPerson(Person person);
	
	Person_Class findByPersonAndTheClass(Person person, Class theClass);
}
