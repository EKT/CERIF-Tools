package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_DublinCore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonDublinCoreCrudRepository extends CrudRepository<Person_DublinCore, Long> {
	
	List<Person_DublinCore> findByPerson(Person person);

}
