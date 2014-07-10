package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.second.Event;

/**
 * A repository for links between organisations and events.
 * 
 */
public interface LinkOrganisationUnitEventRepository {
	
	public void delete(OrganisationUnit_Event entity); 
	
	public void delete(Iterable<OrganisationUnit_Event> entities); 

	public Iterable<OrganisationUnit_Event> save(Iterable<OrganisationUnit_Event> entities); 
	
	public OrganisationUnit_Event save(OrganisationUnit_Event entity);
	
	List<OrganisationUnit_Event> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Event> findByEvent(Event event);

}
