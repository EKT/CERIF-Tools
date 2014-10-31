package gr.ekt.cerif.services.multilingual.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonKeyword;

public interface PersonKeywordRepository {
	
	public void delete(PersonKeyword entity); 
	
	public void delete(Iterable<PersonKeyword> entities); 

	public Iterable<PersonKeyword> save(Iterable<PersonKeyword> entities); 
	
	public PersonKeyword save(PersonKeyword entity);

	List<PersonKeyword> findByPerson(Person person);

}
