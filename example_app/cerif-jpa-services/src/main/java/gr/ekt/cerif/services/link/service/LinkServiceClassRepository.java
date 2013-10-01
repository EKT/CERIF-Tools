package gr.ekt.cerif.services.link.service;

import gr.ekt.cerif.entities.link.Service_Class;

/**
 * A repository for links between services and classes.
 * 
 */
public interface LinkServiceClassRepository {

	public void delete(Service_Class entity); 
	
	public void delete(Iterable<Service_Class> entities); 

	public Iterable<Service_Class> save(Iterable<Service_Class> entities); 
	
	public Service_Class save(Service_Class entity);
	
}
