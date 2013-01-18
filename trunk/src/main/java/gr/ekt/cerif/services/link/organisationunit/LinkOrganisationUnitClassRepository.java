package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between organisations and classes.
 * 
 */

public interface LinkOrganisationUnitClassRepository extends CrudRepository<OrganisationUnit_Class, Long> {

	List <OrganisationUnit_Class> findByOrganisationUnit(OrganisationUnit organisationUnit);
}
