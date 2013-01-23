package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonResultPublicationCrudRepository extends CrudRepository<Person_ResultPublication, Long> {

	List<Person_ResultPublication> findByPerson(Person person);
	
	List<Person_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
}
