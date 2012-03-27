package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.ExpertiseAndSkills_Class;
import gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between expertiseAndSkills and classes.
 * 
 */
@Component
public class LinkExpertiseAndSkillsClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ExpertiseAndSkillsRepository expertiseAndSkillsRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(ExpertiseAndSkills_Class entity) {
		if (entity.getExpertiseAndSkills() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a expertiseAndSkills and a class.");
		}
		if (entity.getExpertiseAndSkills().getId() == null) {
			expertiseAndSkillsRepository.save(entity.getExpertiseAndSkills());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ExpertiseAndSkills_Class> entityList) {
		for (ExpertiseAndSkills_Class entity : entityList) {
			save(entity);
		}
	}
	
}
