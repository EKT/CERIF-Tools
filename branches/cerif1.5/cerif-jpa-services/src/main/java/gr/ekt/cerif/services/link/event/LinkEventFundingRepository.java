package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Funding;

/**
 * A repository for links between events and fundings.
 * 
 */
public interface LinkEventFundingRepository {

	public void delete(Event_Funding entity); 
	
	public void delete(Iterable<Event_Funding> entities); 

	public Iterable<Event_Funding> save(Iterable<Event_Funding> entities); 
	
	public Event_Funding save(Event_Funding entity);
	
}
