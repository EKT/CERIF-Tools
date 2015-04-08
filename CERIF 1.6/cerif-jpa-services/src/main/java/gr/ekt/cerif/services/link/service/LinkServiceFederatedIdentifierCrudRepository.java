package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.second.FederatedIdentifier;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceFederatedIdentifierCrudRepository extends CrudRepository<Service_FederatedIdentifier, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_FederatedIdentifier> findByFederatedIdentifier(FederatedIdentifier federatedIdentifier);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_FederatedIdentifier> findByService(Service service);

}