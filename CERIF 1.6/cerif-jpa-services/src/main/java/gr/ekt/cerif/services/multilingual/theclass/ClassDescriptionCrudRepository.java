/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ClassDescriptionCrudRepository extends CrudRepository<ClassDescription, Long> {
	
	List<ClassDescription> findByTheClass(Class theClass);
	
	List<ClassDescription> findByDescriptionAndClassSchemeAndTranslationAndLanguage(String description, ClassScheme scheme, Translation tra, Language lan);
	
	List<ClassDescription> findByTheClassAndDescriptionAndClassSchemeAndTranslationAndLanguage(Class theClass, String description, ClassScheme scheme, Translation tra, Language lan);

}
