package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitEventCrudRepository extends CrudRepository<OrganisationUnit_Event, Long> {

}
