package gr.ekt.cerif.services.link.federatedidentifier;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;

public interface LinkFederatedIdentifierClassRepository {

	public void delete(FederatedIdentifier_Class entity); 
	
	public void delete(Iterable<FederatedIdentifier_Class> entities); 

	public Iterable<FederatedIdentifier_Class> save(Iterable<FederatedIdentifier_Class> entities); 
	
	public FederatedIdentifier_Class save(FederatedIdentifier_Class entity);
}
