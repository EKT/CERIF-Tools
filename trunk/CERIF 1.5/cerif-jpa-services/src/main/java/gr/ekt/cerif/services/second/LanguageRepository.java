/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Language;

/**
 * @author bonisv
 *
 */
public interface LanguageRepository {

	public void delete(Language entity); 
	
	public void delete(Iterable<Language> entities); 

	public Iterable<Language> save(Iterable<Language> entities); 
	
	public Language save(Language entity);
	
	Language findByCode(String code);
}
