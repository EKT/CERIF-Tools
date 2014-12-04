package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.infrastructure.Service;

public interface ServiceRepository {
	
	Service findById(Long id);
	
	void delete(Service entity); 
	
	void delete(Iterable<Service> entities); 

	Iterable<Service> save(Iterable<Service> entity); 
	
	Service save(Service entity);
	
	List<Service> findAll();
	
	Page<Service> findAll(Pageable page);
	
	Service findByUUID(String uuid);
	
	List<Service> findByUri(String uri);

}
