/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.features.multilingual.EventDescription;

/**
 * @author bonisv
 *
 */
public interface EventDescriptionRepository {

	public void delete(EventDescription entity); 
	
	public void delete(Iterable<EventDescription> entities); 

	public Iterable<EventDescription> save(Iterable<EventDescription> entities); 
	
	public EventDescription save(EventDescription entity);
}
