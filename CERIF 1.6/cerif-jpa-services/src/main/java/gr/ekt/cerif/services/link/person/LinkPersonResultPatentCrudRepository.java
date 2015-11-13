package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonResultPatentCrudRepository extends CrudRepository<Person_ResultPatent, Long> {
	
	List<Person_ResultPatent> findByPerson(Person person);
	
	List<Person_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
