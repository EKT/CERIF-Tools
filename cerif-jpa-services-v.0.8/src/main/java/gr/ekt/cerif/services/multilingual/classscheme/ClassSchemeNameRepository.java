
package gr.ekt.cerif.services.multilingual.classscheme;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.ClassScheme;


/**
 * A repository for ClassSchemeName.
 * 
 */
public interface ClassSchemeNameRepository {
	
	ClassSchemeName findByName(String name);
	
	public void delete(ClassSchemeName entity); 
	
	public void delete(Iterable<ClassSchemeName> entities); 

	public Iterable<ClassSchemeName> save(Iterable<ClassSchemeName> entities); 
	
	public ClassSchemeName save(ClassSchemeName entity);
	
	List<ClassSchemeName> findByScheme(ClassScheme scheme);
	
	ClassSchemeName findByLanguageAndTranslationAndScheme(Language language, Translation translation, ClassScheme classScheme);
	
}
