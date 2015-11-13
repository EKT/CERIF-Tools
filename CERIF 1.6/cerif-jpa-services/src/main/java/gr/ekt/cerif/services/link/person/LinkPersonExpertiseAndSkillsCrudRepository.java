package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonExpertiseAndSkillsCrudRepository extends CrudRepository<Person_ExpertiseAndSkills, Long> {
	
	List<Person_ExpertiseAndSkills> findByPerson(Person person);
	
	@Query(value = "select persexsk "
			+ "  from Person_ExpertiseAndSkills persexsk         	"
			+ "  join persexsk.expertiseAndSkills exsk            	"
			+ "  where exsk = ?1 ")
	List<Person_ExpertiseAndSkills> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
