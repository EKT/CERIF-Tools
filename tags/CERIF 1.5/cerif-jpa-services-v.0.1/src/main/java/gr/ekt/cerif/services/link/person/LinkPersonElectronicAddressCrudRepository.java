/**
 * 
 */
package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between persons and electronic addresses.
 * 
 */

public interface LinkPersonElectronicAddressCrudRepository extends CrudRepository<Person_ElectronicAddress, Long>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List <Person_ElectronicAddress> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_ElectronicAddress> findByElectronicAddress(ElectronicAddress electronicAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List <Person_ElectronicAddress> findByPersonAndElectronicAddress(Person person, ElectronicAddress electronicAddress);
	
}
