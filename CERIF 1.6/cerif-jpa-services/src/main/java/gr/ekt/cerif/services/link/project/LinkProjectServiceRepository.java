/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Service;
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
	
	List<Project_Service> findByService(Service service);
	
	List<Project_Service> findByProject(Project project);
	
}
