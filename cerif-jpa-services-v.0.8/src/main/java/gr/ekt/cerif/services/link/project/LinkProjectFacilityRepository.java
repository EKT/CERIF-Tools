/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.project.Project_Facility;

/**
 * A repository for links between projects and Facilities.
 * 
 */
public interface LinkProjectFacilityRepository {

	public void delete(Project_Facility entity); 
	
	public void delete(Iterable<Project_Facility> entities); 

	public Iterable<Project_Facility> save(Iterable<Project_Facility> entities); 
	
	public Project_Facility save(Project_Facility entity);
	
	List<Project_Facility> findByProject(Project project);
	
	List<Project_Facility> findByFacility(Facility facility);
	
}
