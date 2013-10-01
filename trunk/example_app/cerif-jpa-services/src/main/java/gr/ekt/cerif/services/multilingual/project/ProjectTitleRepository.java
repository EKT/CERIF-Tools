/**
 * 
 */
package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

/**
 * @author bonisv
 *
 */
public interface ProjectTitleRepository {

	ProjectTitle findByTitle(String title);
	
	ProjectTitle findByProject(Project project);
	
	public void delete(ProjectTitle entity); 
	
	public void delete(Iterable<ProjectTitle> entities); 

	public Iterable<ProjectTitle> save(Iterable<ProjectTitle> entities); 
	
	public ProjectTitle save(ProjectTitle entity);
}
