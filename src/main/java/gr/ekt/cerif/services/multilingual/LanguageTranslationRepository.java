/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.LanguageTranslation;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for language translation entities.
 * 
 */
@Component
public class LanguageTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(LanguageTranslation entity) {
		if (entity.getLanguageOfName() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a language of name, a translation and a language.");
		}
		if (entity.getLanguageOfName().getCode() == null) {
			languageRepository.save(entity.getLanguageOfName());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<LanguageTranslation> entityList) {
		for (LanguageTranslation entity : entityList) {
			save(entity);
		}
	}
}

