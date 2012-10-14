/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.IndicatorTranslation;
import gr.ekt.cerif.services.second.IndicatorRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for indicator translation entities.
 * 
 */
@Component
public class IndicatorTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	IndicatorRepository indicatorRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(IndicatorTranslation entity) {
		if (entity.getIndicator() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a indicator, a translation and a language.");
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<IndicatorTranslation> entityList) {
		for (IndicatorTranslation entity : entityList) {
			save(entity);
		}
	}
}

