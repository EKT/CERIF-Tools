/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

/**
 * @author bonisv
 *
 */
@Component
public class ExpertiseAndSkillsRepositoryImpl implements ExpertiseAndSkillsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ExpertiseAndSkillsRepositoryImpl.class);

	@Autowired
	private ExpertiseAndSkillsCrudRepository expertiseAndSkillsCrudRepository;

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository#delete(gr.ekt.cerif.entities.second.ExpertiseAndSkills)
	 */
	@Override
	public void delete(ExpertiseAndSkills entity) {
		expertiseAndSkillsCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<ExpertiseAndSkills> entities) {
		expertiseAndSkillsCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<ExpertiseAndSkills> save(Iterable<ExpertiseAndSkills> entities) {
		return expertiseAndSkillsCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository#save(gr.ekt.cerif.entities.second.ExpertiseAndSkills)
	 */
	@Override
	public ExpertiseAndSkills save(ExpertiseAndSkills entity) {
		return expertiseAndSkillsCrudRepository.save(entity);
	}

}
