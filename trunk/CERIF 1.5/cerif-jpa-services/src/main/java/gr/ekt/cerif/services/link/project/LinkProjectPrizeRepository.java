/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.second.Prize;

/**
 * A repository for links between projects and Facilities.
 * 
 */
public interface LinkProjectPrizeRepository {

	public void delete(Project_Prize entity); 
	
	public void delete(Iterable<Project_Prize> entities); 

	public Iterable<Project_Prize> save(Iterable<Project_Prize> entities); 
	
	public Project_Prize save(Project_Prize entity);
	
	public List<Project_Prize> findByProject(Project project);
	
	public List<Project_Prize> findByPrize(Prize Prize);
	
}
