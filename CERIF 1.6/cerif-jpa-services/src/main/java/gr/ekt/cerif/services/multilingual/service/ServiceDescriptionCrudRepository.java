package gr.ekt.cerif.services.multilingual.service;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServiceDescriptionCrudRepository extends CrudRepository<ServiceDescription, Long> {
	
	List<ServiceDescription> findByService(Service service);

}
