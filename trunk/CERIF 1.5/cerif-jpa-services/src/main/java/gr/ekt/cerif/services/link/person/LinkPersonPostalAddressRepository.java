package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

public interface LinkPersonPostalAddressRepository {

	List<Person_PostalAddress> findByPerson(Person person);
	
	List<Person_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	Person_PostalAddress findByPersonAndPostalAddress (Person person, PostalAddress postalAddress);
	
	void delete(Person_PostalAddress entity); 
	
	void delete(Iterable<Person_PostalAddress> entities); 

	Iterable<Person_PostalAddress> save(Iterable<Person_PostalAddress> entities); 
	
	Person_PostalAddress save(Person_PostalAddress entity);
}
