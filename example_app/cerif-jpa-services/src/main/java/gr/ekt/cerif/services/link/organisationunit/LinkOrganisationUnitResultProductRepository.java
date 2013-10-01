package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;

/**
 * A repository for links between organisations and result products.
 * 
 */
public interface LinkOrganisationUnitResultProductRepository {
	
	public void delete(OrganisationUnit_ResultProduct entity); 
	
	public void delete(Iterable<OrganisationUnit_ResultProduct> entities); 

	public Iterable<OrganisationUnit_ResultProduct> save(Iterable<OrganisationUnit_ResultProduct> entities); 
	
	public OrganisationUnit_ResultProduct save(OrganisationUnit_ResultProduct entity);

}
