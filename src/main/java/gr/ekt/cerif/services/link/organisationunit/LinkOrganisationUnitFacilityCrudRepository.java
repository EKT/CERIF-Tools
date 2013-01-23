package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitFacilityCrudRepository extends CrudRepository<OrganisationUnit_Facility, Long> {

	List<OrganisationUnit_Facility> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
