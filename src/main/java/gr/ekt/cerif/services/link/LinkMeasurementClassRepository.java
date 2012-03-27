package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.services.second.MeasurementRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between measurements and classes.
 * 
 */
@Component
public class LinkMeasurementClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Measurement_Class entity) {
		if (entity.getMeasurement() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a measurement and a class.");
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Measurement_Class> entityList) {
		for (Measurement_Class entity : entityList) {
			save(entity);
		}
	}
	
}
