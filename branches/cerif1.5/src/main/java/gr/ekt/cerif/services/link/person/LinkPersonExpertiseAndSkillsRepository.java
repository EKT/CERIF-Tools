package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and expertiseAndSkills.
 * 
 */
@Component
public class LinkPersonExpertiseAndSkillsRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ExpertiseAndSkillsRepository expertiseAndSkillsRepository;
	
	@Transactional
	public void save(Person_ExpertiseAndSkills entity) {
		if (entity.getPerson() == null || entity.getExpertiseAndSkills() == null) {
			throw new IllegalArgumentException("Please provide both a person and a expertiseAndSkills.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getExpertiseAndSkills().getId() == null) {
			expertiseAndSkillsRepository.save(entity.getExpertiseAndSkills());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_ExpertiseAndSkills> entityList) {
		for (Person_ExpertiseAndSkills entity : entityList) {
			save(entity);
		}
	}
	
}
