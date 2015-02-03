package gr.ekt.cerif.services.link.classscheme;

import java.util.List;

import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * A repository for links between classScheme and class.
 * 
 */
public interface LinkClassSchemeClassRepository {
	
	public void delete(ClassScheme_Class entity); 
	
	public void delete(Iterable<ClassScheme_Class> entities); 

	public Iterable<ClassScheme_Class> save(Iterable<ClassScheme_Class> entities); 
	
	public ClassScheme_Class save(ClassScheme_Class entity);
	
	List<ClassScheme_Class> findByRelatedClassScheme(ClassScheme classScheme);
	
	List<ClassScheme_Class> findByRelatedClass(Class theClass);
	
	List<ClassScheme_Class> findByRelatedClassSchemeAndRelatedClassAndTheClass(ClassScheme classScheme, Class relatedClass, Class theClass);

}
