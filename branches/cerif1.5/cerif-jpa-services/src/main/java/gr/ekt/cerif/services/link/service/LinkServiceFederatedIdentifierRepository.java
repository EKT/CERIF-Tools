package gr.ekt.cerif.services.link.service;

import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;

public interface LinkServiceFederatedIdentifierRepository {
	
	public void delete(Service_FederatedIdentifier entity); 
	
	public void delete(Iterable<Service_FederatedIdentifier> entities); 

	public Iterable<Service_FederatedIdentifier> save(Iterable<Service_FederatedIdentifier> entities); 
	
	public Service_FederatedIdentifier save(Service_FederatedIdentifier entity);

}
