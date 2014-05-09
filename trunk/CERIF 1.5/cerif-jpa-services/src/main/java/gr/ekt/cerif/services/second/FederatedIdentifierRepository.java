/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.FederatedIdentifier;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author bonisv
 *
 */
public interface FederatedIdentifierRepository {

	public void delete(FederatedIdentifier entity); 
	
	public void delete(Iterable<FederatedIdentifier> entities); 

	public Iterable<FederatedIdentifier> save(Iterable<FederatedIdentifier> entities); 
	
	public FederatedIdentifier save(FederatedIdentifier entity);	
	
	List<FederatedIdentifier> findAll();
	
	Page<FederatedIdentifier> findAll(Pageable page);
	
	List<FederatedIdentifier> findFedIdByClassUriAndInstId(String classUri, Long instanceId);
	
	List<FederatedIdentifier> findFedIdByClassUuidAndInstId(String classUuid, Long instanceId);
}
