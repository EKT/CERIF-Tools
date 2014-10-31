/**
 * 
 */
package gr.ekt.cerif.services.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.base.Person;


/**
 * A repository for persons.
 * 
 */
public interface PersonRepository {

	Person findById(Long id);

	void delete(Person entity);
	
	void delete(Iterable<Person> entities);
	
	Iterable<Person> save(Iterable<Person> entities);
	
	Person save(Person entity);
	
	Iterable<Person> findAll();
	
	Page<Person> findAll(Pageable page);

	Person findByUUID(String uuid);
	
	Person findByUri(String uri);
	
}
