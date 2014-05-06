package gr.ekt.cerif.services.link.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.second.FederatedIdentifier;

@Component
public class LinkServiceFederatedIdentifierRepositoryImpl implements
		LinkServiceFederatedIdentifierRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceFederatedIdentifierRepositoryImpl.class);
	
	@Autowired
	private LinkServiceFederatedIdentifierCrudRepository linkServiceFederatedIdentifierCrudRepository;

	@Override
	public void delete(Service_FederatedIdentifier entity) {
		linkServiceFederatedIdentifierCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_FederatedIdentifier> entities) {
		linkServiceFederatedIdentifierCrudRepository.save(entities);
	}

	@Override
	public Iterable<Service_FederatedIdentifier> save(
			Iterable<Service_FederatedIdentifier> entities) {
		return linkServiceFederatedIdentifierCrudRepository.save(entities);
	}

	@Override
	public Service_FederatedIdentifier save(Service_FederatedIdentifier entity) {
		return linkServiceFederatedIdentifierCrudRepository.save(entity);
	}

	@Override
	public List<Service_FederatedIdentifier> findByFedId(
			FederatedIdentifier federatedIdentifier) {
		return linkServiceFederatedIdentifierCrudRepository.findByFedId(federatedIdentifier);
	}

	@Override
	public List<Service_FederatedIdentifier> findByService(Service service) {
		return linkServiceFederatedIdentifierCrudRepository.findByService(service);
	}

}