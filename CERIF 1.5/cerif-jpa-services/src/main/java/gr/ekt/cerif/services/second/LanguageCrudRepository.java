/**
 * 
 */
package gr.ekt.cerif.services.second;


import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Language;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface LanguageCrudRepository extends CrudRepository<Language, String> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Language findByCode(String code);
	
}
