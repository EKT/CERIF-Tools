package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between projects and mediums.
 * 
 */
public interface LinkProjectMediumRepository {

	public void delete(Project_Medium entity); 
	
	public void delete(Iterable<Project_Medium> entities); 

	public Iterable<Project_Medium> save(Iterable<Project_Medium> entities); 
	
	public Project_Medium save(Project_Medium entity);
	
	List<Project_Medium> findByProject(Project project);
	
	List<Project_Medium> findByMedium(Medium medium);
	
}
