package gr.ekt.cerif.services.link.event;

import java.util.List;

import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between events and fundings.
 * 
 */
public interface LinkEventFundingRepository {

	public void delete(Event_Funding entity); 
	
	public void delete(Iterable<Event_Funding> entities); 

	public Iterable<Event_Funding> save(Iterable<Event_Funding> entities); 
	
	public Event_Funding save(Event_Funding entity);
	
	List<Event_Funding> findByEvent(Event event);
	
	List<Event_Funding> findByFunding(Funding funding);
}
