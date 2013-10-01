package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

public interface LinkPersonPostalAddressRepository {

Person_PostalAddress findByPersonName(String personName);
	
	List<Person_PostalAddress> findByPerson(Person person);
	
	List<Person_PostalAddress> findByPerson2(Person person);
	
	Person_PostalAddress findByPersonAndPostalAddress (Person person, PostalAddress postalAddress);
	
	public void delete(Person_PostalAddress entity); 
	
	public void delete(Iterable<Person_PostalAddress> entities); 

	public Iterable<Person_PostalAddress> save(Iterable<Person_PostalAddress> entities); 
	
	public Person_PostalAddress save(Person_PostalAddress entity);
}
