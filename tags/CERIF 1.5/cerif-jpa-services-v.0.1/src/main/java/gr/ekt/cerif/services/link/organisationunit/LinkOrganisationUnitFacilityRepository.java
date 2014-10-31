package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;

/**
 * A repository for links between organisations and facilities.
 * 
 */

public interface LinkOrganisationUnitFacilityRepository {
	
	public OrganisationUnit_Facility save(OrganisationUnit_Facility entity);
	
	public Iterable<? extends OrganisationUnit_Facility> save(Iterable<? extends OrganisationUnit_Facility> entities);
			
	public void delete(OrganisationUnit_Facility entity);
	
	public void delete(Iterable<? extends OrganisationUnit_Facility> entityList);
	
	List<OrganisationUnit_Facility> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Facility> findByFacility(Facility facility);
	
}
