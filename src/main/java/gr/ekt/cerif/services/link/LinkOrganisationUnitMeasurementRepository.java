package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and measurements.
 * 
 */
@Component
public class LinkOrganisationUnitMeasurementRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(OrganisationUnit_Measurement entity) {
		if (entity.getOrganisationUnit() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a measurement.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_Measurement> entityList) {
		for (OrganisationUnit_Measurement entity : entityList) {
			save(entity);
		}
	}

}
