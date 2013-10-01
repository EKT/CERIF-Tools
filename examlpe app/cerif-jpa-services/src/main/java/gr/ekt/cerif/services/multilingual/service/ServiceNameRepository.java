package gr.ekt.cerif.services.multilingual.service;

import gr.ekt.cerif.features.multilingual.ServiceName;

public interface ServiceNameRepository {
	
	public void delete(ServiceName entity); 
	
	public void delete(Iterable<ServiceName> entities); 

	public Iterable<ServiceName> save(Iterable<ServiceName> entities); 
	
	public ServiceName save(ServiceName entity);

}
