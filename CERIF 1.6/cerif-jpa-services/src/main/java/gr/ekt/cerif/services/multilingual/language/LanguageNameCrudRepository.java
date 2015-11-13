/**
 * 
 */
package gr.ekt.cerif.services.multilingual.language;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.LanguageName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface LanguageNameCrudRepository extends CrudRepository<LanguageName, Long> {
	
	List<LanguageName> findByLanguage(Language language);
	
	List<LanguageName> findByLanguageOfName(Language language);

}
