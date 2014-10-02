/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ClassExCrudRepository extends CrudRepository<ClassEx, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassEx> findByTheClass(Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassEx> findByExAndClassSchemeAndTranslationAndLanguage(String example, ClassScheme scheme, Translation tra, Language lan);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassEx> findByTheClassAndExAndClassSchemeAndTranslationAndLanguage(Class theClass, String example, ClassScheme scheme, Translation tra, Language lan);

}
