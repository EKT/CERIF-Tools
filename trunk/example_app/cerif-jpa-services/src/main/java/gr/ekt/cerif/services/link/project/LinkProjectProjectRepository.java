/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Project;

/**
 * A repository for links between projects and organisations.
 * 
 */
public interface LinkProjectProjectRepository {

	List<Project_Project> findByProject1(Project project);
	
	List<Project_Project> findByProject2(Project project);
	
	public Project_Project save(Project_Project entity);
	
	public Iterable<Project_Project> save(Iterable<Project_Project> entityList);
	
	public void delete(Project_Project entity);
	
	public void delete(Iterable<? extends Project_Project> entities);
	
}
