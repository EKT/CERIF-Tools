/**
 * 
 */
package gr.ekt.cerif.services.multilingual.language;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.LanguageName;

/**
 * @author bonisv
 *
 */
public interface LanguageNameRepository {
	
	public void delete(LanguageName entity); 
	
	public void delete(Iterable<LanguageName> entities); 

	public Iterable<LanguageName> save(Iterable<LanguageName> entities); 
	
	public LanguageName save(LanguageName entity);
	
	List<LanguageName> findByLanguage(Language language);
	
	List<LanguageName> findByLanguageOfName(Language language);

}
