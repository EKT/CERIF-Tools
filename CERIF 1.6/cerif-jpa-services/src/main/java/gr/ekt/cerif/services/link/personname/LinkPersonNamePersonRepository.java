package gr.ekt.cerif.services.link.personname;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.features.additional.PersonName;

public interface LinkPersonNamePersonRepository {
	
	void delete(PersonName_Person entity); 
	
	void delete(Iterable<PersonName_Person> entities); 

	Iterable<PersonName_Person> save(Iterable<PersonName_Person> entities); 
	
	PersonName_Person save(PersonName_Person entity);
	
	List<PersonName_Person> findByPersonName(PersonName personName);
	
	List<PersonName_Person> findByPerson(Person person);

}
