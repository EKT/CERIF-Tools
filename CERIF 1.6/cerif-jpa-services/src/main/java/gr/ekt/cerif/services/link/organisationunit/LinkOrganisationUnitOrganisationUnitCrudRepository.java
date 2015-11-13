package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitOrganisationUnitCrudRepository extends CrudRepository<OrganisationUnit_OrganisationUnit, Long> {
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit2(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1AndOrganisationUnit2AndTheClass(OrganisationUnit organisationUnit1, 
			OrganisationUnit organisationUnit2, Class theClass);

}
