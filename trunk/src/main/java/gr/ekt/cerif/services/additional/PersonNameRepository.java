/**
 * 
 */
package gr.ekt.cerif.services.additional;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for personNames.
 * 
 */
public interface PersonNameRepository extends CrudRepository<PersonName, Long> {

	List<PersonName> findByPerson(Person person);
	
}
