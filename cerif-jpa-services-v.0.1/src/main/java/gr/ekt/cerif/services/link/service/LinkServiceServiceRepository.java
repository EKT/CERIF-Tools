package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Service;

/**
 * A repository for links between services.
 * 
 */
public interface LinkServiceServiceRepository {

	public void delete(Service_Service entity); 
	
	public void delete(Iterable<Service_Service> entities); 

	public Iterable<Service_Service> save(Iterable<Service_Service> entities); 
	
	public Service_Service save(Service_Service entity);
	
	List<Service_Service> findByService1(Service service);
	
	List<Service_Service> findByService2(Service service);
	
}
