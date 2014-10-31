/**
 * 
 */
package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.ProjectView;


import java.util.List;

/**
 * A repository for projects.
 * 
 */
public interface ProjectMiddleRepository {
	
	List<ProjectView> findAllProjects();
	
	ProjectView findProjectById(Long id);
	
	List<ProjectView> findProjectByOrganisationIdAndClassScheme(Long id, String classSchemeUUID);
		
}

	
