package gr.ekt.cerif.services.link.federatedidentifier;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFederatedIdentifierClassCrudRepository extends CrudRepository<FederatedIdentifier_Class, Long> {

	List<FederatedIdentifier_Class> findByFederatedIdentifier(FederatedIdentifier federatedIdentifier);
	
	List<FederatedIdentifier_Class> findBytheClass(Class theClass);
	
}