package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceClassCrudRepository extends CrudRepository<Service_Class, Long> {
	
	List<Service_Class> findByService(Service service);
	
	List<Service_Class> findBytheClass(Class theClass);

}
