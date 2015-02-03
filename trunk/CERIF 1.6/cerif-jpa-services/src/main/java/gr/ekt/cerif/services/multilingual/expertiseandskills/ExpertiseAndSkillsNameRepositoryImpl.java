/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;

/**
 * @author bonisv
 *
 */
@Component
public class ExpertiseAndSkillsNameRepositoryImpl implements ExpertiseAndSkillsNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ExpertiseAndSkillsNameRepositoryImpl.class);
	
	@Autowired
	private ExpertiseAndSkillsNameCrudRepository expertiseAndSkillsNameCrudRepository;

	@Override
	public void delete(ExpertiseAndSkillsName entity) {
		expertiseAndSkillsNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ExpertiseAndSkillsName> entities) {
		expertiseAndSkillsNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ExpertiseAndSkillsName> save(Iterable<ExpertiseAndSkillsName> entities) {
		return expertiseAndSkillsNameCrudRepository.save(entities);
	}

	@Override
	public ExpertiseAndSkillsName save(ExpertiseAndSkillsName entity) {
		return expertiseAndSkillsNameCrudRepository.save(entity);
	}

}
