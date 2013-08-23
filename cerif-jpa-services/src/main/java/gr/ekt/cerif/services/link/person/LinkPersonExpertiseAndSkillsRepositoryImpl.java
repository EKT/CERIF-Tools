package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;

@Component
public class LinkPersonExpertiseAndSkillsRepositoryImpl implements
		LinkPersonExpertiseAndSkillsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonExpertiseAndSkillsRepositoryImpl.class);
	
	@Autowired
	private LinkPersonExpertiseAndSkillsCrudRepository linkPersonExpertiseAndSkillsCrudRepository;

	@Override
	public void delete(Person_ExpertiseAndSkills entity) {
		linkPersonExpertiseAndSkillsCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_ExpertiseAndSkills> entities) {
		linkPersonExpertiseAndSkillsCrudRepository.save(entities);
	}

	@Override
	public Iterable<Person_ExpertiseAndSkills> save(
			Iterable<Person_ExpertiseAndSkills> entities) {
		return linkPersonExpertiseAndSkillsCrudRepository.save(entities);
	}

	@Override
	public Person_ExpertiseAndSkills save(Person_ExpertiseAndSkills entity) {
		return linkPersonExpertiseAndSkillsCrudRepository.save(entity);
	}

}
