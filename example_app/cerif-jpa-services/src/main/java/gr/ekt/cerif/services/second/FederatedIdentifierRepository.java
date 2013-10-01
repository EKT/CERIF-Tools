/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.FederatedIdentifier;

/**
 * @author bonisv
 *
 */
public interface FederatedIdentifierRepository {

	public void delete(FederatedIdentifier entity); 
	
	public void delete(Iterable<FederatedIdentifier> entities); 

	public Iterable<FederatedIdentifier> save(Iterable<FederatedIdentifier> entities); 
	
	public FederatedIdentifier save(FederatedIdentifier entity);
}
