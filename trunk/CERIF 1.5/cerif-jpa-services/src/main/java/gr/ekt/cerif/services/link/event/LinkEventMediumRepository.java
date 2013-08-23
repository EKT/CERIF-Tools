package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Medium;
/**
 * A repository for links between events and mediums.
 * 
 */
public interface LinkEventMediumRepository {

	public void delete(Event_Medium entity); 
	
	public void delete(Iterable<Event_Medium> entities); 

	public Iterable<Event_Medium> save(Iterable<Event_Medium> entities); 
	
	public Event_Medium save(Event_Medium entity);
	
}
