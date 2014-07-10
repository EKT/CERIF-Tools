package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.entities.second.Language;

/**
 * A repository for links between persons and languages.
 * 
 */
public interface LinkPersonLanguageRepository {

	public void delete(Person_Language entity); 
	
	public void delete(Iterable<Person_Language> entities); 

	public Iterable<Person_Language> save(Iterable<Person_Language> entities); 
	
	public Person_Language save(Person_Language entity);
	
	List<Person_Language> findByLanguage(Language language);
	
	List<Person_Language> findByPerson(Person person);
	
}
