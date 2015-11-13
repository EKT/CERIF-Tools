package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitFacilityCrudRepository extends CrudRepository<OrganisationUnit_Facility, Long> {

	List<OrganisationUnit_Facility> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Facility> findByFacility(Facility facility);
	
}
