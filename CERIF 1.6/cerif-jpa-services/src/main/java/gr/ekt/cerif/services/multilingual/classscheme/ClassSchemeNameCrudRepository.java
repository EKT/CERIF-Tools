package gr.ekt.cerif.services.multilingual.classscheme;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClassSchemeNameCrudRepository extends CrudRepository<ClassSchemeName, Long> {

	ClassSchemeName findByName(String name);
	
	List<ClassSchemeName> findByScheme(ClassScheme scheme);
	
	ClassSchemeName findByLanguageAndTranslationAndScheme(Language language, Translation translation, ClassScheme classScheme);
	
}
