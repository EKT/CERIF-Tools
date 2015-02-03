/**
 * 
 */
package gr.ekt.cerif.services.multilingual.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;


public interface PersonResearchInterestCrudRepository extends CrudRepository<PersonResearchInterest, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PersonResearchInterest> findByPerson(Person person);

}
