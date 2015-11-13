/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ClassExCrudRepository extends CrudRepository<ClassEx, Long>  {
	
	List<ClassEx> findByTheClass(Class theClass);
	
	List<ClassEx> findByExAndClassSchemeAndTranslationAndLanguage(String example, ClassScheme scheme, Translation tra, Language lan);
	
	List<ClassEx> findByTheClassAndExAndClassSchemeAndTranslationAndLanguage(Class theClass, String example, ClassScheme scheme, Translation tra, Language lan);

}
