/**
 * 
 */
package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between persons and electronic addresses.
 * 
 */

public interface LinkPersonElectronicAddressRepository extends CrudRepository<Person_ElectronicAddress, Long>{

	List <Person_ElectronicAddress> findByPerson(Person person);
	
	List <Person_ElectronicAddress> findByPersonAndElectronicAddress(Person person, ElectronicAddress electronicAddress);
}
