package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between organisations and classes.
 * 
 */

public interface LinkOrganisationUnitClassCrudRepository extends CrudRepository<OrganisationUnit_Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List <OrganisationUnit_Class> findByOrganisationUnit(OrganisationUnit organisationUnit);
}
