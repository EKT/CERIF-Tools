package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Indicator;

/**
 * A repository for links between events and indicators.
 * 
 */
public interface LinkEventIndicatorRepository {

	public void delete(Event_Indicator entity); 
	
	public void delete(Iterable<Event_Indicator> entities); 

	public Iterable<Event_Indicator> save(Iterable<Event_Indicator> entities); 
	
	public Event_Indicator save(Event_Indicator entity);
	
}
