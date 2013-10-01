/**
 * 
 */
package gr.ekt.cerif.services.additional;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for personNames.
 * 
 */
public interface PersonNameCrudRepository extends CrudRepository<PersonName, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PersonName> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pn	" +
			   "  from Person p    		 	" +
			   "  join p.personNames pn		" +
			   " where p.id = ?1            ")
	List<PersonName> findPersonNamesByPersonId(Long id);
	
}
