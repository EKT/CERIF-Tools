/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Language;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface LanguageRepository extends CrudRepository<Language, String> {
	
}
