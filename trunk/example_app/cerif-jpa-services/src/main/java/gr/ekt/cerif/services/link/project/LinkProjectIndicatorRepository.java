package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Indicator;

/**
 * A repository for links between projects and indicators.
 * 
 */
public interface LinkProjectIndicatorRepository {

	public void delete(Project_Indicator entity); 
	
	public void delete(Iterable<Project_Indicator> entities); 

	public Iterable<Project_Indicator> save(Iterable<Project_Indicator> entities); 
	
	public Project_Indicator save(Project_Indicator entity);
	
}
