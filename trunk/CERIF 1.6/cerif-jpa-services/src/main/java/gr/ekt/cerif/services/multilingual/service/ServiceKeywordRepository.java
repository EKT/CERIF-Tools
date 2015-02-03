package gr.ekt.cerif.services.multilingual.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;

public interface ServiceKeywordRepository {
	
	public void delete(ServiceKeyword entity); 
	
	public void delete(Iterable<ServiceKeyword> entities); 

	public Iterable<ServiceKeyword> save(Iterable<ServiceKeyword> entities); 
	
	public ServiceKeyword save(ServiceKeyword entity);
	
	List<ServiceKeyword> findByService(Service service);

}
