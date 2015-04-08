/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import java.util.List;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsNameRepository {
	
	public void delete(ExpertiseAndSkillsName entity); 
	
	public void delete(Iterable<ExpertiseAndSkillsName> entities); 

	public Iterable<ExpertiseAndSkillsName> save(Iterable<ExpertiseAndSkillsName> entities); 
	
	public ExpertiseAndSkillsName save(ExpertiseAndSkillsName entity);
	
	List<ExpertiseAndSkillsName> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
