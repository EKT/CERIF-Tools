package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.services.second.LanguageRepository;
import gr.ekt.cerif.services.semantics.ClassSchemeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClassSchemeNameRepositoryImpl implements ClassSchemeNameRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ClassSchemeNameCrudRepository classSchemeNameCrudRepository;
	
	@Autowired
	ClassSchemeRepository classSchemeRepository;
	
	@Autowired
	LanguageRepository languageRepository;

	@Transactional
	public ClassSchemeName save(ClassSchemeName entity) {
		if (entity.getClassScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a class scheme, a translation and a language.");
		}
		if (entity.getClassScheme().getId() == null) {
			classSchemeRepository.save(entity.getClassScheme());
		}
		languageRepository.save(entity.getLanguage());
		return entityManager.merge(entity);
	}

	@Transactional
	public Iterable<? extends ClassSchemeName> save(Iterable<? extends ClassSchemeName> entities) {
		for (ClassSchemeName entity : entities) {
			save(entity);
		}
		return entities;
	}

	public ClassSchemeName findByName(String name) {
		return classSchemeNameCrudRepository.findByName(name);
	}

	@Transactional
	public void delete(ClassSchemeName entity) {
		classSchemeNameCrudRepository.delete(entity);
	}
}
