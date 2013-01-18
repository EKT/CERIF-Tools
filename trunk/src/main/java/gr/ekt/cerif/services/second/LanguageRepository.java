/**
 * 
 */
package gr.ekt.cerif.services.second;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Language;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface LanguageRepository extends CrudRepository<Language, String> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select l from Language l where l.code = ?1")
	Language findLanguageByCode(String code);

}
