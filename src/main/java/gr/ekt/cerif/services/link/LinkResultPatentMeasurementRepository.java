package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and measurements.
 * 
 */
@Component
public class LinkResultPatentMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(ResultPatent_Measurement entity) {
		if (entity.getResultPatent() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a measurement.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Measurement> entityList) {
		for (ResultPatent_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
