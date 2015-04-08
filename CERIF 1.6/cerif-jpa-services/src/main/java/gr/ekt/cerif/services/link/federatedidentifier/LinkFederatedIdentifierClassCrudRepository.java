package gr.ekt.cerif.services.link.federatedidentifier;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFederatedIdentifierClassCrudRepository extends CrudRepository<FederatedIdentifier_Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<FederatedIdentifier_Class> findByFederatedIdentifier(FederatedIdentifier federatedIdentifier);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<FederatedIdentifier_Class> findBytheClass(Class theClass);
	
}