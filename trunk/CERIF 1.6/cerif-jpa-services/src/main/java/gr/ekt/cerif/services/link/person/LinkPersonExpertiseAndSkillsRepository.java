package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

/**
 * A repository for links between persons and expertiseAndSkills.
 * 
 */
public interface LinkPersonExpertiseAndSkillsRepository {

	public void delete(Person_ExpertiseAndSkills entity); 
	
	public void delete(Iterable<Person_ExpertiseAndSkills> entities); 

	public Iterable<Person_ExpertiseAndSkills> save(Iterable<Person_ExpertiseAndSkills> entities); 
	
	public Person_ExpertiseAndSkills save(Person_ExpertiseAndSkills entity);
	
	List<Person_ExpertiseAndSkills> findByPerson(Person person);
	
	List<Person_ExpertiseAndSkills> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);
	
}
