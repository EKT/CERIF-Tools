package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and facilitys.
 * 
 */
@Component
public class LinkOrganisationUnitFacilityServiceImpl implements LinkOrganisationUnitFacilityService {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Override
	@Transactional
	public void save(OrganisationUnit_Facility entity) {
		if (entity.getOrganisationUnit() == null || entity.getFacility() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an facility.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		entityManager.merge(entity);
	}
	
	@Override
	@Transactional
	public void save(List<? extends OrganisationUnit_Facility> entities) {
		for (OrganisationUnit_Facility entity : entities) {
			save(entity);
		}
	}

}
