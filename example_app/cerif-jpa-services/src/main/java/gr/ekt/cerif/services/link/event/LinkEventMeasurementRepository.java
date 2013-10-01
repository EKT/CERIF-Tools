package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Measurement;

/**
 * A repository for links between events and measurements.
 * 
 */
public interface LinkEventMeasurementRepository {

	public void delete(Event_Measurement entity); 
	
	public void delete(Iterable<Event_Measurement> entities); 

	public Iterable<Event_Measurement> save(Iterable<Event_Measurement> entities); 
	
	public Event_Measurement save(Event_Measurement entity);
	
}
