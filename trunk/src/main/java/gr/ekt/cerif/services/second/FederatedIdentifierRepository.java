package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.FederatedIdentifier;

import org.springframework.data.repository.CrudRepository;

public interface FederatedIdentifierRepository extends CrudRepository<FederatedIdentifier, Long> {

}
