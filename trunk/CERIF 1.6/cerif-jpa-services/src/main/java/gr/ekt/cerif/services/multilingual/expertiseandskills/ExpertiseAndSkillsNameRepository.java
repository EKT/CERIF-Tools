/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

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

}
