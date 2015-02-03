/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.second.Event;

/**
 * A repository for links between projects and eventes.
 * 
 */
public interface LinkProjectEventRepository {

	public void delete(Project_Event entity); 
	
	public void delete(Iterable<Project_Event> entities); 

	public Iterable<Project_Event> save(Iterable<Project_Event> entities); 
	
	public Project_Event save(Project_Event entity);
	
	List<Project_Event> findByProject(Project project);
	
	List<Project_Event> findByEvent(Event event);
}
