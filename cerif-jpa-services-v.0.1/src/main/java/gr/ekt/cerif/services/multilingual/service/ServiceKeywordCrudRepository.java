package gr.ekt.cerif.services.multilingual.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ServiceKeywordCrudRepository extends CrudRepository<ServiceKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ServiceKeyword> findByService(Service service);

}
