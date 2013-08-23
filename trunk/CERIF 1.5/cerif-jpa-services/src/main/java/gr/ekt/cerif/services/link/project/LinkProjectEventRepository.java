/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Event;

/**
 * A repository for links between projects and eventes.
 * 
 */
public interface LinkProjectEventRepository {

	public void delete(Project_Event entity); 
	
	public void delete(Iterable<Project_Event> entities); 

	public Iterable<Project_Event> save(Iterable<Project_Event> entities); 
	
	public Project_Event save(Project_Event entity);
	
}
