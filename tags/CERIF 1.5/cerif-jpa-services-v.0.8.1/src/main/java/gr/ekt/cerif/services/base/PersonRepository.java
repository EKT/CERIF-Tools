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

	Person findByUuid(String uuid);
	
	Person findByUri(String uri);
	
	/**
	 * Retrieves a person, based on its UUID, along with its multi-lingual fields.
	 * @param uuid The UUID.
	 * @return a person.
	 */
	Person findByUuidFetchMultilingual(String uuid);

	/**
	 * Retrieves a person, based on its UUID, along with its multi-lingual fields and its federated identifiers.
	 * @param uuid The UUID.
	 * @return a project.
	 */
	Person findByUuidFetchMultilingualAndFederatedIds(String uuid);
	
}
