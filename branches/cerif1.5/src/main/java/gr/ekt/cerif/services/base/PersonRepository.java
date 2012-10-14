/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for persons.
 * 
 */
public interface PersonRepository extends CrudRepository<Person, String> {

}
