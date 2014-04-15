package gr.ekt.cerif.services.link.classscheme;

import gr.ekt.cerif.entities.link.ClassScheme_Class;

/**
 * A repository for links between classScheme and class.
 * 
 */
public interface LinkClassSchemeClassRepository {
	
	public void delete(ClassScheme_Class entity); 
	
	public void delete(Iterable<ClassScheme_Class> entities); 

	public Iterable<ClassScheme_Class> save(Iterable<ClassScheme_Class> entities); 
	
	public ClassScheme_Class save(ClassScheme_Class entity);

}
