/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Service;

/**
 * A repository for links between projects and Services.
 * 
 */
public interface LinkProjectServiceRepository {

	public void delete(Project_Service entity); 
	
	public void delete(Iterable<Project_Service> entities); 

	public Iterable<Project_Service> save(Iterable<Project_Service> entities); 
	
	public Project_Service save(Project_Service entity);
	
}
