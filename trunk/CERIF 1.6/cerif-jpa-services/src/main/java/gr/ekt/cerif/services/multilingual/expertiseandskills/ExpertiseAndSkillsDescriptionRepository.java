/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import java.util.List;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsDescriptionRepository {
	
	public void delete(ExpertiseAndSkillsDescription entity); 
	
	public void delete(Iterable<ExpertiseAndSkillsDescription> entities); 

	public Iterable<ExpertiseAndSkillsDescription> save(Iterable<ExpertiseAndSkillsDescription> entities); 
	
	public ExpertiseAndSkillsDescription save(ExpertiseAndSkillsDescription entity);
	
	List<ExpertiseAndSkillsDescription> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
