package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;

public interface LinkPersonElectronicAddressRepository {
	
	List <Person_ElectronicAddress> findByPerson(Person person);
	
	List <Person_ElectronicAddress> findByPersonAndElectronicAddress(Person person, ElectronicAddress electronicAddress);

	public void delete(Person_ElectronicAddress entity); 
	
	public void delete(Iterable<Person_ElectronicAddress> entities); 

	public Iterable<Person_ElectronicAddress> save(Iterable<Person_ElectronicAddress> entities); 
	
	public Person_ElectronicAddress save(Person_ElectronicAddress entity);
}
