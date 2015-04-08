package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.second.FederatedIdentifier;

public interface LinkServiceFederatedIdentifierRepository {
	
	public void delete(Service_FederatedIdentifier entity); 
	
	public void delete(Iterable<Service_FederatedIdentifier> entities); 

	public Iterable<Service_FederatedIdentifier> save(Iterable<Service_FederatedIdentifier> entities); 
	
	public Service_FederatedIdentifier save(Service_FederatedIdentifier entity);
	
	List<Service_FederatedIdentifier> findByFederatedIdentifier(FederatedIdentifier federatedIdentifier);
	
	List<Service_FederatedIdentifier> findByService(Service service);

}