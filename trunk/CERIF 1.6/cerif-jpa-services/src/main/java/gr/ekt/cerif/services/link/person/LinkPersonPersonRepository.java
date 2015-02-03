package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Person;

public interface LinkPersonPersonRepository {
	
	List<Person_Person> findByPerson1(Person person);
	
	List<Person_Person> findByPerson2(Person person);
	
	public void delete(Person_Person entity); 
	
	public void delete(Iterable<Person_Person> entities); 

	public Iterable<Person_Person> save(Iterable<Person_Person> entities); 
	
	public Person_Person save(Person_Person entity);

}
