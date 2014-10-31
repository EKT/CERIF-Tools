/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * @author bonisv
 *
 */
public interface ClassDescriptionRepository {

	public void delete(ClassDescription entity); 
	
	public void delete(Iterable<ClassDescription> entities); 

	public Iterable<ClassDescription> save(Iterable<ClassDescription> entities); 
	
	public ClassDescription save(ClassDescription entity);
	
	List<ClassDescription> findByTheClass(Class theClass);
	
	List<ClassDescription> findByDescriptionAndClassSchemeAndTranslationAndLanguage(String description, ClassScheme scheme, Translation tra, Language lan);
	
	List<ClassDescription> findByTheClassAndDescriptionAndClassSchemeAndTranslationAndLanguage(Class theClass, String description, ClassScheme scheme, Translation tra, Language lan);
}
