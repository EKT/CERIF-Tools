package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;

/**
 * A repository for links between organisations and mediums.
 * 
 */
public interface LinkOrganisationUnitMediumRepository {
	
	public void delete(OrganisationUnit_Medium entity); 
	
	public void delete(Iterable<OrganisationUnit_Medium> entities); 

	public Iterable<OrganisationUnit_Medium> save(Iterable<OrganisationUnit_Medium> entities); 
	
	public OrganisationUnit_Medium save(OrganisationUnit_Medium entity);

}
