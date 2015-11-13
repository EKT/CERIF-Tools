package gr.ekt.cerif.services.multilingual.service;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServiceKeywordCrudRepository extends CrudRepository<ServiceKeyword, Long> {
	
	List<ServiceKeyword> findByService(Service service);

}
