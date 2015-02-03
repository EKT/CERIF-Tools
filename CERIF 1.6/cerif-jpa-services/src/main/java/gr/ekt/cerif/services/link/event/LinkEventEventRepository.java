package gr.ekt.cerif.services.link.event;

import java.util.List;

import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.second.Event;

/**
 * A repository for links between events.
 * 
 */
public interface LinkEventEventRepository {

	public void delete(Event_Event entity); 
	
	public void delete(Iterable<Event_Event> entities); 

	public Iterable<Event_Event> save(Iterable<Event_Event> entities); 
	
	public Event_Event save(Event_Event entity);
	
	List<Event_Event> findByEvent1(Event event1);
	
	List<Event_Event> findByEvent2(Event event2);
	
}
