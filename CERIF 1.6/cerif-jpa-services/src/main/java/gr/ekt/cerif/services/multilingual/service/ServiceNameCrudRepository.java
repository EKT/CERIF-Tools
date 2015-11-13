package gr.ekt.cerif.services.multilingual.service;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServiceNameCrudRepository extends CrudRepository<ServiceName, Long> {
	
	List<ServiceName> findByService(Service service);

}
