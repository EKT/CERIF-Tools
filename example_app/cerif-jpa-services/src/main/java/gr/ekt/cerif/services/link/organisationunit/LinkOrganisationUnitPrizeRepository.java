package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
/**
 * A repository for links between organisations and prizes.
 * 
 */
public interface LinkOrganisationUnitPrizeRepository {
	
	public void delete(OrganisationUnit_Prize entity); 
	
	public void delete(Iterable<OrganisationUnit_Prize> entities); 

	public Iterable<OrganisationUnit_Prize> save(Iterable<OrganisationUnit_Prize> entities); 
	
	public OrganisationUnit_Prize save(OrganisationUnit_Prize entity);

}
