package gr.ekt.cerif.services.link.expertiseandskills;

import gr.ekt.cerif.entities.link.ExpertiseAndSkills_Class;

/**
 * A repository for links between expertiseAndSkills and classes.
 * 
 */
public interface LinkExpertiseAndSkillsClassRepository {

	public void delete(ExpertiseAndSkills_Class entity); 
	
	public void delete(Iterable<ExpertiseAndSkills_Class> entities); 

	public Iterable<ExpertiseAndSkills_Class> save(Iterable<ExpertiseAndSkills_Class> entities); 
	
	public ExpertiseAndSkills_Class save(ExpertiseAndSkills_Class entity);
	
}
