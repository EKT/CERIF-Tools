package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;

/**
 * A repository for links between organisations and fundings.
 * 
 */
public interface LinkOrganisationUnitFundingRepository {
	
	public void delete(OrganisationUnit_Funding entity); 
	
	public void delete(Iterable<OrganisationUnit_Funding> entities); 

	public Iterable<OrganisationUnit_Funding> save(Iterable<OrganisationUnit_Funding> entities); 
	
	public OrganisationUnit_Funding save(OrganisationUnit_Funding entity);

}
