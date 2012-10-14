/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.MetricsTranslation;
import gr.ekt.cerif.services.second.MetricsRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for metrics translation entities.
 * 
 */
@Component
public class MetricsTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	MetricsRepository metricsRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(MetricsTranslation entity) {
		if (entity.getMetrics() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a metrics, a translation and a language.");
		}
		if (entity.getMetrics().getId() == null) {
			metricsRepository.save(entity.getMetrics());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<MetricsTranslation> entityList) {
		for (MetricsTranslation entity : entityList) {
			save(entity);
		}
	}
}

