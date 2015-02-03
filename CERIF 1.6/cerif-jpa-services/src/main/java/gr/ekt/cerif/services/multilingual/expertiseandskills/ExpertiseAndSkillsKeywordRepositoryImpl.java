/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class ExpertiseAndSkillsKeywordRepositoryImpl implements ExpertiseAndSkillsKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ExpertiseAndSkillsKeywordRepositoryImpl.class);
	
	@Autowired
	private ExpertiseAndSkillsKeywordCrudRepository expertiseAndSkillsKeywordCrudRepository;

	@Override
	public void delete(ExpertiseAndSkillsKeyword entity) {
		expertiseAndSkillsKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ExpertiseAndSkillsKeyword> entities) {
		expertiseAndSkillsKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ExpertiseAndSkillsKeyword> save(Iterable<ExpertiseAndSkillsKeyword> entities) {
		return expertiseAndSkillsKeywordCrudRepository.save(entities);
	}

	@Override
	public ExpertiseAndSkillsKeyword save(ExpertiseAndSkillsKeyword entity) {
		return expertiseAndSkillsKeywordCrudRepository.save(entity);
	}

}
