package gr.ekt.cerif.services.link.federatedidentifier;

import java.util.List;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;

public interface LinkFederatedIdentifierClassRepository {

	public void delete(FederatedIdentifier_Class entity); 
	
	public void delete(Iterable<FederatedIdentifier_Class> entities); 

	public Iterable<FederatedIdentifier_Class> save(Iterable<FederatedIdentifier_Class> entities); 
	
	public FederatedIdentifier_Class save(FederatedIdentifier_Class entity);
	
	List<FederatedIdentifier_Class> findByFederatedIdentifier(FederatedIdentifier federatedIdentifier);
	
	List<FederatedIdentifier_Class> findBytheClass(Class theClass);
}