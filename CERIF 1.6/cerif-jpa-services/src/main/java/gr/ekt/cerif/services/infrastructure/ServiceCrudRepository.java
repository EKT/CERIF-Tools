package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {
	
	public List<Service> findAll();
	
	public Page<Service> findAll(Pageable page);

	public Service findByUuid(String uuid);
	
	public Service findById(Long Id);
	
	public List<Service> findByUri(String uri);

}
