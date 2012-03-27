package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between measurements.
 * 
 */
@Component
public class LinkMeasurementMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Measurement_Measurement entity) {
		if (entity.getMeasurement1() == null || entity.getMeasurement2() == null) {
			throw new IllegalArgumentException("Please provide both measurements.");
		}
		if (entity.getMeasurement1().getId() == null) {
			measurementRepository.save(entity.getMeasurement1());
		}
		if (entity.getMeasurement2().getId() == null) {
			measurementRepository.save(entity.getMeasurement2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Measurement_Measurement> entityList) {
		for (Measurement_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
