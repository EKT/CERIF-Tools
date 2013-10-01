/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsRepository {

	public void delete(ExpertiseAndSkills entity); 
	
	public void delete(Iterable<ExpertiseAndSkills> entities); 

	public Iterable<ExpertiseAndSkills> save(Iterable<ExpertiseAndSkills> entities); 
	
	public ExpertiseAndSkills save(ExpertiseAndSkills entity);
}
