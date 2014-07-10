
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;



/**
 * A repository for ClassTerm.
 * 
 */
public interface ClassTermRepository {
	
	ClassTerm findByTerm(String term);
	
	List<ClassTerm> findByTheClass(Class theClass);
	
	public void delete(ClassTerm entity); 
	
	public void delete(Iterable<ClassTerm> entities); 

	public Iterable<ClassTerm> save(Iterable<ClassTerm> entities); 
	
	public ClassTerm save(ClassTerm entity);
	
	ClassTerm findByTheClassAndClassSchemeAndLanguageAndTranslation(Class theClass, ClassScheme classScheme, Language language, Translation translation);
	
	List<ClassTerm> findByTermAndClassSchemeAndTranslationAndLanguage(String term, ClassScheme scheme, Translation tra, Language lan);
}
