package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Medium;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonMediumCrudRepository extends CrudRepository<Person_Medium, Long> {
	
	List<Person_Medium> findByPerson(Person person);

}
