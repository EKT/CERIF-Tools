package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.infrastructure.Service;

public interface ServiceRepository {
	
	public Service findById(Long id);
	
	public void delete(Service entity); 
	
	public void delete(Iterable<Service> entities); 

	public Iterable<Service> save(Iterable<Service> entity); 
	
	public Service save(Service entity);
	
	List<Service> findAll();
	
	Page<Service> findAll(Pageable page);
	
	Service findByUUID(String uuid);

}
