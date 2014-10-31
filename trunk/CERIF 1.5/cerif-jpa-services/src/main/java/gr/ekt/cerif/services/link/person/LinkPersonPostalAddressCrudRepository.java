package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between persons and countries.
 * 
 */

public interface LinkPersonPostalAddressCrudRepository extends CrudRepository<Person_PostalAddress, Long>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_PostalAddress> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Person_PostalAddress findByPersonAndPostalAddress (Person person, PostalAddress postalAddress);
	
}
