package gr.ekt.cerif.services.link.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonExpertiseAndSkillsCrudRepository extends CrudRepository<Person_ExpertiseAndSkills, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_ExpertiseAndSkills> findByPerson(Person person);

}
