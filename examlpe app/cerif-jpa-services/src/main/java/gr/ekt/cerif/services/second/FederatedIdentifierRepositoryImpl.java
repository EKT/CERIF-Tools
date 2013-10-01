/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.FederatedIdentifier;

/**
 * @author bonisv
 *
 */
@Component
public class FederatedIdentifierRepositoryImpl implements FederatedIdentifierRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FederatedIdentifierRepositoryImpl.class);
	
	@Autowired
	private FederatedIdentifierCrudRepository federatedIdentifierCrudRepository;

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#delete(gr.ekt.cerif.entities.second.FederatedIdentifier)
	 */
	@Override
	public void delete(FederatedIdentifier entity) {
		federatedIdentifierCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<FederatedIdentifier> entities) {
		federatedIdentifierCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<FederatedIdentifier> save(Iterable<FederatedIdentifier> entities) {
		return federatedIdentifierCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#save(gr.ekt.cerif.entities.second.FederatedIdentifier)
	 */
	@Override
	public FederatedIdentifier save(FederatedIdentifier entity) {
		return federatedIdentifierCrudRepository.save(entity);
	}

}
