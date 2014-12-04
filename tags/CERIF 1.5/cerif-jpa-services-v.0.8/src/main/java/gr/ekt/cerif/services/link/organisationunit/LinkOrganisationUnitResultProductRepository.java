package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for links between organisations and result products.
 * 
 */
public interface LinkOrganisationUnitResultProductRepository {
	
	public void delete(OrganisationUnit_ResultProduct entity); 
	
	public void delete(Iterable<OrganisationUnit_ResultProduct> entities); 

	public Iterable<OrganisationUnit_ResultProduct> save(Iterable<OrganisationUnit_ResultProduct> entities); 
	
	public OrganisationUnit_ResultProduct save(OrganisationUnit_ResultProduct entity);
	
	List<OrganisationUnit_ResultProduct> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ResultProduct> findByResultProduct(ResultProduct resultProduct);

}
