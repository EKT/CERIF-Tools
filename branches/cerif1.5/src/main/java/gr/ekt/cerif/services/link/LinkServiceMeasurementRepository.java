package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between services and measurements.
 * 
 */
@Component
public class LinkServiceMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Service_Measurement entity) {
		if (entity.getService() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a service and a measurement.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Measurement> entityList) {
		for (Service_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
