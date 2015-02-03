package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between facilities and mediumes.
 * 
 */
public interface LinkServiceMediumRepository {

	public void delete(Service_Medium entity); 
	
	public void delete(Iterable<Service_Medium> entities); 

	public Iterable<Service_Medium> save(Iterable<Service_Medium> entities); 
	
	public Service_Medium save(Service_Medium entity);
	
	List<Service_Medium> findByMedium(Medium medium);
	
	List<Service_Medium> findByService(Service service);
	
}
