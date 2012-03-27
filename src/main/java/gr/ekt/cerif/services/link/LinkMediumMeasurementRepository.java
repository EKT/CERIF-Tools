package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between mediums and measurements.
 * 
 */
@Component
public class LinkMediumMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Medium_Measurement entity) {
		if (entity.getMedium() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a medium and a measurement.");
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Medium_Measurement> entityList) {
		for (Medium_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
