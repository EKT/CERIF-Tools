package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between services and classes.
 * 
 */
public interface LinkServiceClassRepository {

	public void delete(Service_Class entity); 
	
	public void delete(Iterable<Service_Class> entities); 

	public Iterable<Service_Class> save(Iterable<Service_Class> entities); 
	
	public Service_Class save(Service_Class entity);
	
	List<Service_Class> findByService(Service service);
	
	List<Service_Class> findBytheClass(Class theClass);
	
}
