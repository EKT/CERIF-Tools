/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.MediumTranslation;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for medium translation entities.
 * 
 */
@Component
public class MediumTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	MediumRepository mediumRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(MediumTranslation entity) {
		if (entity.getMedium() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a medium, a translation and a language.");
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<MediumTranslation> entityList) {
		for (MediumTranslation entity : entityList) {
			save(entity);
		}
	}
}

