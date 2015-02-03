package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitOrganisationUnitCrudRepository extends CrudRepository<OrganisationUnit_OrganisationUnit, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit2(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1AndOrganisationUnit2AndTheClass(OrganisationUnit organisationUnit1, 
			OrganisationUnit organisationUnit2, Class theClass);

}
