package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitFacilityRepositoryImpl implements LinkOrganisationUnitFacilityRepository {

	@Autowired
	private LinkOrganisationUnitFacilityCrudRepository linkOrganisationUnitFacilityCrudRepository;

	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	FacilityRepository facilityRepository;

	@Transactional
	public OrganisationUnit_Facility save(OrganisationUnit_Facility entity) {
		return linkOrganisationUnitFacilityCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<OrganisationUnit_Facility> save(Iterable<OrganisationUnit_Facility> entities) {
		return linkOrganisationUnitFacilityCrudRepository.save(entities);
	}
	
	public List<OrganisationUnit_Facility> findByOrganisationUnit(OrganisationUnit organisationUnit) {
		return linkOrganisationUnitFacilityCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Transactional
	public void delete(OrganisationUnit_Facility entity) {
		linkOrganisationUnitFacilityCrudRepository.delete(entity);
		
	}

	@Transactional
	public void delete(Iterable<OrganisationUnit_Facility> entityList) {
		linkOrganisationUnitFacilityCrudRepository.delete(entityList);
	}

	@Override
	public List<OrganisationUnit_Facility> findByFacility(Facility facility) {
		return linkOrganisationUnitFacilityCrudRepository.findByFacility(facility);
	}
}
