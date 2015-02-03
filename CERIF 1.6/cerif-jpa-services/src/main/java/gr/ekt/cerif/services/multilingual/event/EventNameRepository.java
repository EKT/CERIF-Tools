/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import java.util.List;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventName;

/**
 * @author bonisv
 *
 */
public interface EventNameRepository {

	EventName findByName(String title);	
	
	public void delete(EventName entity); 
	
	public void delete(Iterable<EventName> entities); 

	public Iterable<EventName> save(Iterable<EventName> entities); 
	
	public EventName save(EventName entity);
	
	List<EventName> findByEvent(Event event);
}
