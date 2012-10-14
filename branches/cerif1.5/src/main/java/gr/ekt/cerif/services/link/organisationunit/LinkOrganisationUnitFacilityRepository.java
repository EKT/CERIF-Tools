package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between organisations and facilities.
 * 
 */

public interface LinkOrganisationUnitFacilityRepository extends CrudRepository<OrganisationUnit_Facility, Long>{
	OrganisationUnit_Facility findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	
}
