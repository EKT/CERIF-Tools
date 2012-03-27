package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.services.second.IndicatorRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between indicators and measurements.
 * 
 */
@Component
public class LinkIndicatorMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Indicator_Measurement entity) {
		if (entity.getIndicator() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a indicator and a measurement.");
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Indicator_Measurement> entityList) {
		for (Indicator_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
