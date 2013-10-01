package gr.ekt.cerif.services.link.service;

import gr.ekt.cerif.entities.link.Service_Event;

/**
 * A repository for links between facilities and eventes.
 * 
 */
public interface LinkServiceEventRepository {

	public void delete(Service_Event entity); 
	
	public void delete(Iterable<Service_Event> entities); 

	public Iterable<Service_Event> save(Iterable<Service_Event> entities); 
	
	public Service_Event save(Service_Event entity);
	
}
