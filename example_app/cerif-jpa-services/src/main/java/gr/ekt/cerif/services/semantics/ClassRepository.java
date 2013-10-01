/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.transferobjects.ClassView;

import java.util.List;


/**
 * A repository for links between facilities and classes.
 * 
 */

public interface ClassRepository {

	Class findById(Long id);
    
	List<Class> findByUri(String uri);
	
	List<Class> findByScheme(ClassScheme scheme);
	
	public void delete(Class entity);
	
	public void delete(Iterable<Class> entityList);
	
	public Iterable<Class> save(Iterable<Class> entityList);
	
	public Class save(Class entity);
	
	public Class findOne(Long id);
	
	List<ClassView> findClassByProjectIdAndClassScheme(Long id, String classSchemeUri);
	
	List<ClassView> findClassByOrganisationIdAndClassScheme(Long id, String classSchemeUri);
	
}
