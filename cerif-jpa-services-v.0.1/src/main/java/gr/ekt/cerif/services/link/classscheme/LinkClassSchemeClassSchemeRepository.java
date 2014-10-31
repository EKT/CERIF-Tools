package gr.ekt.cerif.services.link.classscheme;

import gr.ekt.cerif.entities.link.ClassScheme_ClassScheme;

/**
 * A repository for links between classSchemes.
 * 
 */
public interface LinkClassSchemeClassSchemeRepository {

	public void delete(ClassScheme_ClassScheme entity); 
	
	public void delete(Iterable<ClassScheme_ClassScheme> entities); 

	public Iterable<ClassScheme_ClassScheme> save(Iterable<ClassScheme_ClassScheme> entities); 
	
	public ClassScheme_ClassScheme save(ClassScheme_ClassScheme entity);
	
}
