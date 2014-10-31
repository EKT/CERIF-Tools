/**
 * 
 */
package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.ClassView;

import java.util.List;


/**
 * A repository for links between facilities and classes.
 * 
 */

public interface ClassMiddleRepository {
	
	List<ClassView> findClassByProjectIdAndClassScheme(Long id, String classSchemeUUID);
	
	List<ClassView> findClassByOrganisationIdAndClassScheme(Long id, String classSchemeUUID);

	
}
