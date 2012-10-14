/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxTranslation;
import gr.ekt.cerif.services.second.GeographicBoundingBoxRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for geographic bounding box translation entities.
 * 
 */
@Component
public class GeographicBoundingBoxTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	GeographicBoundingBoxRepository geographicBoundingBoxRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(GeographicBoundingBoxTranslation entity) {
		if (entity.getGeographicBoundingBox() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a geographic bounding box, a translation and a language.");
		}
		if (entity.getGeographicBoundingBox().getId() == null) {
			geographicBoundingBoxRepository.save(entity.getGeographicBoundingBox());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<GeographicBoundingBoxTranslation> entityList) {
		for (GeographicBoundingBoxTranslation entity : entityList) {
			save(entity);
		}
	}
}
