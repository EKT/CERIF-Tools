package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonEventCrudRepository extends CrudRepository<Person_Event, Long> {
	
	List<Person_Event> findByPerson(Person person);
	
	List<Person_Event> findByEvent(Event event);

}
