/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;


/**
 * @author bonisv
 *
 */
@Component
public class ExpertiseAndSkillsDescriptionRepositoryImpl implements ExpertiseAndSkillsDescriptionRepository {

	private static final Logger log = LoggerFactory.getLogger(ExpertiseAndSkillsDescriptionRepositoryImpl.class);
	
	@Autowired
	private ExpertiseAndSkillsDescriptionCrudRepository expertiseAndSkillsDescriptionCrudRepository;

	@Override
	public void delete(ExpertiseAndSkillsDescription entity) {
		expertiseAndSkillsDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ExpertiseAndSkillsDescription> entities) {	
		expertiseAndSkillsDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ExpertiseAndSkillsDescription> save(Iterable<ExpertiseAndSkillsDescription> entities) {
		return expertiseAndSkillsDescriptionCrudRepository.save(entities);
	}

	@Override
	public ExpertiseAndSkillsDescription save(ExpertiseAndSkillsDescription entity) {
		return expertiseAndSkillsDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<ExpertiseAndSkillsDescription> findByExpertiseAndSkills(
			ExpertiseAndSkills expertiseAndSkills) {
		return expertiseAndSkillsDescriptionCrudRepository.findByExpertiseAndSkills(expertiseAndSkills);
	}

}
