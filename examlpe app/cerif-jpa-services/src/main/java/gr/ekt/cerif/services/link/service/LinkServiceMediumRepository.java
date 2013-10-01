package gr.ekt.cerif.services.link.service;

import gr.ekt.cerif.entities.link.Service_Medium;

/**
 * A repository for links between facilities and mediumes.
 * 
 */
public interface LinkServiceMediumRepository {

	public void delete(Service_Medium entity); 
	
	public void delete(Iterable<Service_Medium> entities); 

	public Iterable<Service_Medium> save(Iterable<Service_Medium> entities); 
	
	public Service_Medium save(Service_Medium entity);
	
}
