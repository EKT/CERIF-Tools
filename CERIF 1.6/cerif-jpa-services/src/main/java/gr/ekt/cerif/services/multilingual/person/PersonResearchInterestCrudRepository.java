/**
 * 
 */
package gr.ekt.cerif.services.multilingual.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PersonResearchInterestCrudRepository extends CrudRepository<PersonResearchInterest, Long> {
	
	List<PersonResearchInterest> findByPerson(Person person);

}
