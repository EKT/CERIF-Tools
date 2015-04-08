/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import java.util.List;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsKeywordRepository {
	
	public void delete(ExpertiseAndSkillsKeyword entity); 
	
	public void delete(Iterable<ExpertiseAndSkillsKeyword> entities); 

	public Iterable<ExpertiseAndSkillsKeyword> save(Iterable<ExpertiseAndSkillsKeyword> entities); 
	
	public ExpertiseAndSkillsKeyword save(ExpertiseAndSkillsKeyword entity);
	
	List<ExpertiseAndSkillsKeyword> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
