package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Event;

public interface EventRepository {
	
	public Event findById(Long id);
	
	public void delete(Event entity); 
	
	public void delete(Iterable<Event> entities); 

	public Iterable<Event> save(Iterable<Event> entities); 
	
	public Event save(Event entity);
	
}
