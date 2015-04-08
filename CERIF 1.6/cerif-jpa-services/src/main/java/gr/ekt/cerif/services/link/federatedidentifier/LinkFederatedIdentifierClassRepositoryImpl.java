package gr.ekt.cerif.services.link.federatedidentifier;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkFederatedIdentifierClassRepositoryImpl implements
		LinkFederatedIdentifierClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFederatedIdentifierClassRepositoryImpl.class);
	
	@Autowired
	private LinkFederatedIdentifierClassCrudRepository linkFederatedIdentifierClassCrudRepository;

	@Override
	public void delete(FederatedIdentifier_Class entity) {
		linkFederatedIdentifierClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<FederatedIdentifier_Class> entities) {
		linkFederatedIdentifierClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FederatedIdentifier_Class> save(
			Iterable<FederatedIdentifier_Class> entities) {
		return linkFederatedIdentifierClassCrudRepository.save(entities);
	}

	@Override
	public FederatedIdentifier_Class save(FederatedIdentifier_Class entity) {
		return linkFederatedIdentifierClassCrudRepository.save(entity);
	}

	@Override
	public List<FederatedIdentifier_Class> findByFederatedIdentifier(
			FederatedIdentifier federatedIdentifier) {
		return linkFederatedIdentifierClassCrudRepository.findByFederatedIdentifier(federatedIdentifier);
	}

	@Override
	public List<FederatedIdentifier_Class> findBytheClass(Class theClass) {
		return linkFederatedIdentifierClassCrudRepository.findBytheClass(theClass);
	}

}