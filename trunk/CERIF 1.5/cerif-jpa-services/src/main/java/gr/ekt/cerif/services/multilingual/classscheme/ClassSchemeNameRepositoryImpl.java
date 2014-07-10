package gr.ekt.cerif.services.multilingual.classscheme;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClassSchemeNameRepositoryImpl implements ClassSchemeNameRepository {

	@Autowired
	ClassSchemeNameCrudRepository classSchemeNameCrudRepository;

	@Transactional
	public ClassSchemeName save(ClassSchemeName entity) {
		return classSchemeNameCrudRepository.save(entity);
	}

	public ClassSchemeName findByName(String name) {
		return classSchemeNameCrudRepository.findByName(name);
	}

	@Transactional
	public void delete(ClassSchemeName entity) {
		classSchemeNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ClassSchemeName> entities) {
		classSchemeNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ClassSchemeName> save(Iterable<ClassSchemeName> entities) {
		return classSchemeNameCrudRepository.save(entities);
	}

	@Override
	public List<ClassSchemeName> findByScheme(ClassScheme scheme) {
		return classSchemeNameCrudRepository.findByScheme(scheme);
	}

	@Override
	public ClassSchemeName findByLanguageAndTranslationAndScheme(
			Language language, Translation translation, ClassScheme classScheme) {
		return classSchemeNameCrudRepository.findByLanguageAndTranslationAndScheme(language, translation, classScheme);
	}
}
