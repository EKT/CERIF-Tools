package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitEventCrudRepository extends CrudRepository<OrganisationUnit_Event, Long> {
	
	List<OrganisationUnit_Event> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Event> findByEvent(Event event);

}
