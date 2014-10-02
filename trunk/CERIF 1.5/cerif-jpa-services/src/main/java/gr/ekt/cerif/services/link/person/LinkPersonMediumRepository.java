package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

/**
 * A repository for links between persons and countries.
 * 
 */
public interface LinkPersonMediumRepository {

	Person_Medium save(Person_Medium entity);
	
	Iterable<? extends Person_Medium> save(Iterable<? extends Person_Medium> entityList);
	
	List<Person_Medium> findByPerson(Person person);
	
	void delete(Person_Medium entity);
	
	void delete(Iterable<? extends Person_Medium> entities);
	
	List<Person_Medium> findByMedium(Medium medium);
	
}
