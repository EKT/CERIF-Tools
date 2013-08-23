package gr.ekt.cerif.services.link.language;

import gr.ekt.cerif.entities.link.Language_Class;

/**
 * A repository for links between languages and classes.
 * 
 */
public interface LinkLanguageClassRepository {

	public void delete(Language_Class entity); 
	
	public void delete(Iterable<Language_Class> entities); 

	public Iterable<Language_Class> save(Iterable<Language_Class> entities); 
	
	public Language_Class save(Language_Class entity);
	
}
