/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ClassTranslation;
import gr.ekt.cerif.services.second.LanguageRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for class translation entities.
 * 
 */
@Component
public class ClassTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ClassRepository classRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ClassTranslation entity) {
		if (entity.getTheClass() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a class, a translation and a language.");
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ClassTranslation> entityList) {
		for (ClassTranslation entity : entityList) {
			save(entity);
		}
	}
}
