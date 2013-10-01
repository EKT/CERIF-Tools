package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Event;

/**
 * A repository for links between events.
 * 
 */
public interface LinkEventEventRepository {

	public void delete(Event_Event entity); 
	
	public void delete(Iterable<Event_Event> entities); 

	public Iterable<Event_Event> save(Iterable<Event_Event> entities); 
	
	public Event_Event save(Event_Event entity);
	
}
