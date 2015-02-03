package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between organisations.
 * 
 */
public interface LinkOrganisationUnitOrganisationUnitRepository {
	
	void delete(OrganisationUnit_OrganisationUnit entity); 
	
	void delete(Iterable<OrganisationUnit_OrganisationUnit> entities); 

	Iterable<OrganisationUnit_OrganisationUnit> save(Iterable<OrganisationUnit_OrganisationUnit> entities); 
	
	OrganisationUnit_OrganisationUnit save(OrganisationUnit_OrganisationUnit entity);
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit2(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1AndOrganisationUnit2AndTheClass(OrganisationUnit organisationUnit1, 
			OrganisationUnit organisationUnit2, Class theClass);

}
