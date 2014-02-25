package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import gr.ekt.cerif.entities.infrastructure.Service;

public interface ServiceCrudRepository extends CrudRepository<Service, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service> findAll();

}
