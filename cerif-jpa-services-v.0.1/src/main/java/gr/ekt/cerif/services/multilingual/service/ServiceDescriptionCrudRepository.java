package gr.ekt.cerif.services.multilingual.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ServiceDescriptionCrudRepository extends CrudRepository<ServiceDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ServiceDescription> findByService(Service service);

}
