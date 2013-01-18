package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;

/**
 * A repository for links between organisations and facilities.
 * 
 */

public interface LinkOrganisationUnitFacilityRepository {
	
	public OrganisationUnit_Facility save(OrganisationUnit_Facility entity);
	
	public Iterable<? extends OrganisationUnit_Facility> save(Iterable<? extends OrganisationUnit_Facility> entities);
			
	OrganisationUnit_Facility findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
