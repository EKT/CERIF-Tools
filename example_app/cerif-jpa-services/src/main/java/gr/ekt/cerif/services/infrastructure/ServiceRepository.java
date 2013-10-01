package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Service;

public interface ServiceRepository {
	
	public void delete(Service entity); 
	
	public void delete(Iterable<Service> entities); 

	public Iterable<Service> save(Iterable<Service> entity); 
	
	public Service save(Service entity);

}
