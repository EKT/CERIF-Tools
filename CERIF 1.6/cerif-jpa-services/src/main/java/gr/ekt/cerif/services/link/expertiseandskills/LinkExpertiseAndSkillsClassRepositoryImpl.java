package gr.ekt.cerif.services.link.expertiseandskills;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.ExpertiseAndSkills_Class;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkExpertiseAndSkillsClassRepositoryImpl implements
		LinkExpertiseAndSkillsClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkExpertiseAndSkillsClassRepositoryImpl.class);
	
	@Autowired
	private LinkExpertiseAndSkillsClassCrudRepository linkExpertiseAndSkillsClassCrudRepository;

	@Override
	public void delete(ExpertiseAndSkills_Class entity) {
		linkExpertiseAndSkillsClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ExpertiseAndSkills_Class> entities) {
		linkExpertiseAndSkillsClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ExpertiseAndSkills_Class> save(
			Iterable<ExpertiseAndSkills_Class> entities) {
		return linkExpertiseAndSkillsClassCrudRepository.save(entities);
	}

	@Override
	public ExpertiseAndSkills_Class save(ExpertiseAndSkills_Class entity) {
		return linkExpertiseAndSkillsClassCrudRepository.save(entity);
	}

	@Override
	public List<ExpertiseAndSkills_Class> findByExpertiseAndSkills(
			ExpertiseAndSkills expertiseAndSkills) {
		return linkExpertiseAndSkillsClassCrudRepository.findByExpertiseAndSkills(expertiseAndSkills);
	}

	@Override
	public List<ExpertiseAndSkills_Class> findBytheClass(Class theClass) {
		return linkExpertiseAndSkillsClassCrudRepository.findBytheClass(theClass);
	}

}
