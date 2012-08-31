package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between persons and countryes.
 * 
 */

public interface LinkPersonPAddrRepository  extends CrudRepository<Person_PostalAddress, Long>{
	
	Person_PostalAddress findByPerson(Person person);
	
	Person_PostalAddress findByPersonAndPostalAddress (Person person, PostalAddress postalAddress);
}
