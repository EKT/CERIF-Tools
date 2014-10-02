/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.services.link.federatedidentifier.LinkFederatedIdentifierClassRepository;
import gr.ekt.cerif.services.link.service.LinkServiceFederatedIdentifierRepository;

/**
 * @author bonisv
 *
 */
@Component
public class FederatedIdentifierRepositoryImpl implements FederatedIdentifierRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FederatedIdentifierRepositoryImpl.class);
	
	@Autowired
	private FederatedIdentifierCrudRepository federatedIdentifierCrudRepository;
	
	@Autowired
	private LinkFederatedIdentifierClassRepository linkFederatedIdentifierClassRepository;
	
	@Autowired
	private LinkServiceFederatedIdentifierRepository linkServiceFederatedIdentifierRepository;
	

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#delete(gr.ekt.cerif.entities.second.FederatedIdentifier)
	 */
	@Override
	@Transactional
	public void delete(FederatedIdentifier entity) {
		List<FederatedIdentifier_Class> fedcl = linkFederatedIdentifierClassRepository.findByFedId(entity);
		if (fedcl != null) linkFederatedIdentifierClassRepository.delete(fedcl);
		entity.setFedIds_classes(null);
		
		List<Service_FederatedIdentifier> srvfed = linkServiceFederatedIdentifierRepository.findByFedId(entity);
		if (srvfed != null) linkServiceFederatedIdentifierRepository.delete(srvfed);
		entity.setServices_fedIds(null);
		
		entity = federatedIdentifierCrudRepository.save(entity);
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

	@Override
	public List<FederatedIdentifier> findAll() {
		return federatedIdentifierCrudRepository.findAll();
	}

	@Override
	public Page<FederatedIdentifier> findAll(Pageable page) {
		return federatedIdentifierCrudRepository.findAll(page);
	}

	@Override
	public List<FederatedIdentifier> findFedIdByClassUriAndInstId(
			String classUri, Long instanceId) {
		return federatedIdentifierCrudRepository.findFedIdByClassUriAndInstId(classUri, instanceId);
	}

	@Override
	public List<FederatedIdentifier> findFedIdByClassUuidAndInstId(
			String classUuid, Long instanceId) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(classUuid, instanceId);
	}

	@Override
	public FederatedIdentifier findById(Long id) {
		return federatedIdentifierCrudRepository.findOne(id);
	}

	@Override
	public FederatedIdentifier findByUUID(String uuid) {
		return federatedIdentifierCrudRepository.findByUuid(uuid);
	}

}
