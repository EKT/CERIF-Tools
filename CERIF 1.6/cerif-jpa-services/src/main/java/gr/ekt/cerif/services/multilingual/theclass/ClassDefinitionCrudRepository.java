/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ClassDefinitionCrudRepository extends CrudRepository<ClassDefinition, Long> {
	
	List<ClassDefinition> findByTheClass(Class theClass);
	
	List<ClassDefinition> findByDefinitionAndClassSchemeAndTranslationAndLanguage(String definition, ClassScheme scheme, Translation tra, Language lan);
	
	List<ClassDefinition> findByTheClassAndDefinitionAndClassSchemeAndTranslationAndLanguage(Class theClass, String definition, ClassScheme scheme, Translation tra, Language lan);

}
