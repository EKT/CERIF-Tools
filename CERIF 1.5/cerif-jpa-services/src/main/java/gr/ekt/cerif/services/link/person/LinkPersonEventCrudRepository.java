package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Event;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonEventCrudRepository extends CrudRepository<Person_Event, Long> {

}
