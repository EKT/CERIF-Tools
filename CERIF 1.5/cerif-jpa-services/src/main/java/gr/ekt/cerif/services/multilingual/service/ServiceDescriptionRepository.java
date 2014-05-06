package gr.ekt.cerif.services.multilingual.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceDescription;

public interface ServiceDescriptionRepository {
	
	public void delete(ServiceDescription entity); 
	
	public void delete(Iterable<ServiceDescription> entities); 

	public Iterable<ServiceDescription> save(Iterable<ServiceDescription> entities); 
	
	public ServiceDescription save(ServiceDescription entity);
	
	List<ServiceDescription> findByService(Service service);

}
