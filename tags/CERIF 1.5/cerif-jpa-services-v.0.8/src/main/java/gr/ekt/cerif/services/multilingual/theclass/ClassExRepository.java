/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * @author bonisv
 *
 */
public interface ClassExRepository {

	public void delete(ClassEx entity); 
	
	public void delete(Iterable<ClassEx> entities); 

	public Iterable<ClassEx> save(Iterable<ClassEx> entities); 
	
	public ClassEx save(ClassEx entity);
	
	List<ClassEx> findByTheClass(Class theClass);
	
	List<ClassEx> findByExAndClassSchemeAndTranslationAndLanguage(String example, ClassScheme scheme, Translation tra, Language lan);
	
	List<ClassEx> findByTheClassAndExAndClassSchemeAndTranslationAndLanguage(Class theClass, String example, ClassScheme scheme, Translation tra, Language lan);
}
