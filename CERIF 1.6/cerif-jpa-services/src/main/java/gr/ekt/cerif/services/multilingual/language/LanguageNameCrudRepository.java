/**
 * 
 */
package gr.ekt.cerif.services.multilingual.language;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.LanguageName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface LanguageNameCrudRepository extends CrudRepository<LanguageName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<LanguageName> findByLanguage(Language language);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<LanguageName> findByLanguageOfName(Language language);

}
