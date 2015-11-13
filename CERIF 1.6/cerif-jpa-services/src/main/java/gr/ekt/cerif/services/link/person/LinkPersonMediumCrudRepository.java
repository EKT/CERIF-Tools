package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonMediumCrudRepository extends CrudRepository<Person_Medium, Long> {
	
	List<Person_Medium> findByPerson(Person person);
	
	List<Person_Medium> findByMedium(Medium medium);

}
