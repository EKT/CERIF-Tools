/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author bonisv
 *
 */
public interface FederatedIdentifierRepository {

	void delete(FederatedIdentifier entity); 
	
	void delete(Iterable<FederatedIdentifier> entities); 

	Iterable<FederatedIdentifier> save(Iterable<FederatedIdentifier> entities); 
	
	FederatedIdentifier save(FederatedIdentifier entity);	
	
	List<FederatedIdentifier> findAll();
	
	Page<FederatedIdentifier> findAll(Pageable page);
	
	List<FederatedIdentifier> findFedIdByClassUriAndInstId(String classUri, Long instanceId);
	
	List<FederatedIdentifier> findFedIdByClassUuidAndInstId(String classUuid, Long instanceId);
	
	List<FederatedIdentifier> findFedIdByClassClassSchemeInstIdAndFedId(Class theClass, ClassScheme classScheme, Long instanceId, String fedId);
	
	List<FederatedIdentifier> findFedIdByClassClassSchemeAndFedId(Class theClass, ClassScheme classScheme, String fedId, Class fedType);
	
	FederatedIdentifier findByUuid(String uuid);
	
	FederatedIdentifier findById(Long id);
}
