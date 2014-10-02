/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ClassDefinitionCrudRepository extends CrudRepository<ClassDefinition, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassDefinition> findByTheClass(Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassDefinition> findByDefinitionAndClassSchemeAndTranslationAndLanguage(String definition, ClassScheme scheme, Translation tra, Language lan);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassDefinition> findByTheClassAndDefinitionAndClassSchemeAndTranslationAndLanguage(Class theClass, String definition, ClassScheme scheme, Translation tra, Language lan);

}
