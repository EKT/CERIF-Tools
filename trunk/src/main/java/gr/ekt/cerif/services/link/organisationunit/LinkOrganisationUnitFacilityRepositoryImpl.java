package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitFacilityRepositoryImpl implements LinkOrganisationUnitFacilityRepository {

	@Autowired
	private LinkOrganisationUnitFacilityCrudRepository linkOrganisationUnitFacilityCrudRepository;

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	FacilityRepository facilityRepository;

	@Transactional
	public OrganisationUnit_Facility save(OrganisationUnit_Facility entity) {
		if (entity.getOrganisationUnit() == null || entity.getFacility() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an facility.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<? extends OrganisationUnit_Facility> save(Iterable<? extends OrganisationUnit_Facility> entities) {
		for (OrganisationUnit_Facility entity : entities) {
			save(entity);
		}
		return entities;
	}
	
	public OrganisationUnit_Facility findByOrganisationUnit(OrganisationUnit organisationUnit) {
		return linkOrganisationUnitFacilityCrudRepository.findByOrganisationUnit(organisationUnit);
	}
}
