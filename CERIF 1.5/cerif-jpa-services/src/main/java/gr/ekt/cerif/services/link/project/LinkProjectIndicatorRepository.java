package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

/**
 * A repository for links between projects and indicators.
 * 
 */
public interface LinkProjectIndicatorRepository {

	public void delete(Project_Indicator entity); 
	
	public void delete(Iterable<Project_Indicator> entities); 

	public Iterable<Project_Indicator> save(Iterable<Project_Indicator> entities); 
	
	public Project_Indicator save(Project_Indicator entity);
	
	public List<Project_Indicator> findByProject(Project project);
	
	public List<Project_Indicator> findByIndicator(Indicator indicator);
	
}
