/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_ResultPatent;

/**
 * A repository for links between projects and ResultPatents.
 * 
 */
public interface LinkProjectResultPatentRepository {

	public void delete(Project_ResultPatent entity); 
	
	public void delete(Iterable<Project_ResultPatent> entities); 

	public Iterable<Project_ResultPatent> save(Iterable<Project_ResultPatent> entities); 
	
	public Project_ResultPatent save(Project_ResultPatent entity);
	
}
