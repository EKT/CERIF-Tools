package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Medium;

/**
 * A repository for links between projects and mediums.
 * 
 */
public interface LinkProjectMediumRepository {

	public void delete(Project_Medium entity); 
	
	public void delete(Iterable<Project_Medium> entities); 

	public Iterable<Project_Medium> save(Iterable<Project_Medium> entities); 
	
	public Project_Medium save(Project_Medium entity);
	
}
