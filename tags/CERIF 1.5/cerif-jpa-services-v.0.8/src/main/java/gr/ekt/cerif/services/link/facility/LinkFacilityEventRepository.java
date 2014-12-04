package gr.ekt.cerif.services.link.facility;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.second.Event;

/**
 * A repository for links between facilities and events.
 * 
 */
public interface LinkFacilityEventRepository {

	public void delete(Facility_Event entity); 
	
	public void delete(Iterable<Facility_Event> entities); 

	public Iterable<Facility_Event> save(Iterable<Facility_Event> entities); 
	
	public Facility_Event save(Facility_Event entity);
	
	List<Facility_Event> findByFacility(Facility facility);
	
	List<Facility_Event> findByEvent(Event event);
	
}
