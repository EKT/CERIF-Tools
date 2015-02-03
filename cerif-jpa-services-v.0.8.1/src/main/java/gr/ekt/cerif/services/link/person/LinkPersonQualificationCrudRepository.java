package gr.ekt.cerif.services.link.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.second.Qualification;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonQualificationCrudRepository  extends CrudRepository<Person_Qualification, Long>{
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_Qualification> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_Qualification> findByQualification(Qualification qualification);

}
