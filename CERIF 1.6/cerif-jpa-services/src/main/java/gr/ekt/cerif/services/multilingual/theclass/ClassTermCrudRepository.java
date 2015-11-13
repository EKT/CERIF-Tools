package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClassTermCrudRepository extends CrudRepository<ClassTerm, Long> {

	ClassTerm findByTerm(String term);
	
	List<ClassTerm> findByTheClass(Class theClass);
	
	ClassTerm findByTheClassAndClassSchemeAndLanguageAndTranslation(Class theClass, ClassScheme classScheme, Language language, Translation translation);
	
	List<ClassTerm> findByTermAndClassSchemeAndTranslationAndLanguage(String term, ClassScheme scheme, Translation tra, Language lan);
	
	List<ClassTerm> findByTheClassAndTermAndClassSchemeAndTranslationAndLanguage(Class theClass, String term, ClassScheme scheme, Translation tra, Language lan);
	
}
