package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;

/**
 * A repository for links between organisations and services.
 * 
 */
public interface LinkOrganisationUnitServiceRepository {
	
	public void delete(OrganisationUnit_Service entity); 
	
	public void delete(Iterable<OrganisationUnit_Service> entities); 

	public Iterable<OrganisationUnit_Service> save(Iterable<OrganisationUnit_Service> entities); 
	
	public OrganisationUnit_Service save(OrganisationUnit_Service entity);

}
