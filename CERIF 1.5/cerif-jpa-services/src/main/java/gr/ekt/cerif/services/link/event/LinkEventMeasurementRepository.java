package gr.ekt.cerif.services.link.event;

import java.util.List;

import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between events and measurements.
 * 
 */
public interface LinkEventMeasurementRepository {

	public void delete(Event_Measurement entity); 
	
	public void delete(Iterable<Event_Measurement> entities); 

	public Iterable<Event_Measurement> save(Iterable<Event_Measurement> entities); 
	
	public Event_Measurement save(Event_Measurement entity);
	
	List<Event_Measurement> findByEvent(Event event);
	
	List<Event_Measurement> findByMeasurement(Measurement mkeasurement);
	
}
