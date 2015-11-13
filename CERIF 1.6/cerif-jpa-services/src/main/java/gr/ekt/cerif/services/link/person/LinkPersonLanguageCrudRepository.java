package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.entities.second.Language;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonLanguageCrudRepository extends CrudRepository<Person_Language, Long> {
	
	List<Person_Language> findByLanguage(Language language);
	
	List<Person_Language> findByPerson(Person person);

}
