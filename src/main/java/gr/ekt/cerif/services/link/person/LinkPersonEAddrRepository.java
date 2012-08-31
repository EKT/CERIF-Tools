/**
 * 
 */
package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and electronic addresses.
 * 
 */

public interface LinkPersonEAddrRepository extends CrudRepository<Person_ElectronicAddress, Long>{

	List <Person_ElectronicAddress> findByPerson(Person person);
	
	List <Person_ElectronicAddress> findByPersonAndElectronicAddress(Person person, ElectronicAddress electronicAddress);
}
