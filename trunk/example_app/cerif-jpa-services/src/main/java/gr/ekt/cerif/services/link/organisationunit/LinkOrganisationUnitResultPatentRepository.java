package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;

/**
 * A repository for links between organisations and result patents.
 * 
 */
public interface LinkOrganisationUnitResultPatentRepository {
	
	public void delete(OrganisationUnit_ResultPatent entity); 
	
	public void delete(Iterable<OrganisationUnit_ResultPatent> entities); 

	public Iterable<OrganisationUnit_ResultPatent> save(Iterable<OrganisationUnit_ResultPatent> entities); 
	
	public OrganisationUnit_ResultPatent save(OrganisationUnit_ResultPatent entity);

}
