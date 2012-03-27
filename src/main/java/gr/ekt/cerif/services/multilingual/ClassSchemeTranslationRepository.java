/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ClassSchemeTranslation;
import gr.ekt.cerif.services.second.LanguageRepository;
import gr.ekt.cerif.services.semantics.ClassSchemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for class scheme translation entities.
 * 
 */
@Component
public class ClassSchemeTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ClassSchemeRepository classSchemeRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ClassSchemeTranslation entity) {
		if (entity.getClassScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a class scheme, a translation and a language.");
		}
		if (entity.getClassScheme().getId() == null) {
			classSchemeRepository.save(entity.getClassScheme());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ClassSchemeTranslation> entityList) {
		for (ClassSchemeTranslation entity : entityList) {
			save(entity);
		}
	}

}
