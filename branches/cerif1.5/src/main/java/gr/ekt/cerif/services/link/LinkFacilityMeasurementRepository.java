package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and measurements.
 * 
 */
@Component
public class LinkFacilityMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Facility_Measurement entity) {
		if (entity.getFacility() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a measurement.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Measurement> entityList) {
		for (Facility_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
