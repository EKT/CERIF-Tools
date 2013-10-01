package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;

/**
 * A repository for links between organisations.
 * 
 */
public interface LinkOrganisationUnitOrganisationUnitRepository {
	
	public void delete(OrganisationUnit_OrganisationUnit entity); 
	
	public void delete(Iterable<OrganisationUnit_OrganisationUnit> entities); 

	public Iterable<OrganisationUnit_OrganisationUnit> save(Iterable<OrganisationUnit_OrganisationUnit> entities); 
	
	public OrganisationUnit_OrganisationUnit save(OrganisationUnit_OrganisationUnit entity);

}
