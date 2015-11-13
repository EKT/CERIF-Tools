package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.second.Qualification;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonQualificationCrudRepository  extends CrudRepository<Person_Qualification, Long>{
	
	List<Person_Qualification> findByPerson(Person person);
	
	List<Person_Qualification> findByQualification(Qualification qualification);

}
