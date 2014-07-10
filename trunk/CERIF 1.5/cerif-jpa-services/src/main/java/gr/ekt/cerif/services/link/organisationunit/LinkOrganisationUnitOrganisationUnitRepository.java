package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
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
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit2(OrganisationUnit organisationUnit);

}
