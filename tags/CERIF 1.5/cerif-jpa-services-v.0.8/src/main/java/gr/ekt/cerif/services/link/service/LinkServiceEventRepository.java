package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.second.Event;

/**
 * A repository for links between facilities and eventes.
 * 
 */
public interface LinkServiceEventRepository {

	public void delete(Service_Event entity); 
	
	public void delete(Iterable<Service_Event> entities); 

	public Iterable<Service_Event> save(Iterable<Service_Event> entities); 
	
	public Service_Event save(Service_Event entity);
	
	List<Service_Event> findByEvent(Event event);
	
	List<Service_Event> findByService(Service service);
	
}
