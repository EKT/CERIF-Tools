package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceMediumCrudRepository extends CrudRepository<Service_Medium, Long> {
	
	List<Service_Medium> findByMedium(Medium medium);
	
	List<Service_Medium> findByService(Service service);

}
