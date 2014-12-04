/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

/**
 * A repository for links between projects and ResultPatents.
 * 
 */
public interface LinkProjectResultPatentRepository {

	public void delete(Project_ResultPatent entity); 
	
	public void delete(Iterable<Project_ResultPatent> entities); 

	public Iterable<Project_ResultPatent> save(Iterable<Project_ResultPatent> entities); 
	
	public Project_ResultPatent save(Project_ResultPatent entity);
	
	List<Project_ResultPatent> findByProject(Project project);
	
	List<Project_ResultPatent> findByResultPatent(ResultPatent resultPatent);
	
}
