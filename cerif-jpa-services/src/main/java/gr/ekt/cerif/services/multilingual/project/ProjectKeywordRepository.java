/**
 * 
 */
package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.features.multilingual.ProjectKeyword;

/**
 * @author bonisv
 *
 */
public interface ProjectKeywordRepository {
	
	public void delete(ProjectKeyword entity); 
	
	public void delete(Iterable<ProjectKeyword> entities); 

	public Iterable<ProjectKeyword> save(Iterable<ProjectKeyword> entities); 
	
	public ProjectKeyword save(ProjectKeyword entity);

}
