/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.MeasurementTranslation;
import gr.ekt.cerif.services.second.MeasurementRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for measurement translation entities.
 * 
 */
@Component
public class MeasurementTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	MeasurementRepository measurementRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(MeasurementTranslation entity) {
		if (entity.getMeasurement() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a measurement, a translation and a language.");
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<MeasurementTranslation> entityList) {
		for (MeasurementTranslation entity : entityList) {
			save(entity);
		}
	}
}

