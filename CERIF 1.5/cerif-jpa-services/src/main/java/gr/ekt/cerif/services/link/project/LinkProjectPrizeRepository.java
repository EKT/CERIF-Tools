/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Prize;

/**
 * A repository for links between projects and Facilities.
 * 
 */
public interface LinkProjectPrizeRepository {

	public void delete(Project_Prize entity); 
	
	public void delete(Iterable<Project_Prize> entities); 

	public Iterable<Project_Prize> save(Iterable<Project_Prize> entities); 
	
	public Project_Prize save(Project_Prize entity);
	
}
