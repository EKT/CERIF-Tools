package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * A repository for links between persons.
 * 
 */
@Component
public interface LinkPersonPersonRepository  extends CrudRepository<Person_Person, Long> {
	
}

