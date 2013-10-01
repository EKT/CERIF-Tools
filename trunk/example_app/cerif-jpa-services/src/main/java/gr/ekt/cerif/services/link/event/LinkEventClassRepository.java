package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Class;

/**
 * A repository for links between countries and classes.
 * 
 */
public interface LinkEventClassRepository {

	public void delete(Event_Class entity); 
	
	public void delete(Iterable<Event_Class> entities); 

	public Iterable<Event_Class> save(Iterable<Event_Class> entities); 
	
	public Event_Class save(Event_Class entity);
	
}
