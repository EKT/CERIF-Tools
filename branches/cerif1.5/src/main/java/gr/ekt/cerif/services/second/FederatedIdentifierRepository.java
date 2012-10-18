/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.second.FederatedIdentifier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author user
 *
 */
public interface FederatedIdentifierRepository extends CrudRepository<FederatedIdentifier, Long> {

	public FederatedIdentifier findById(Long id);
	public List<FederatedIdentifier> findByInstanceId(Long instanceId);
	public FederatedIdentifier findByFedId(String fedId);
	
	@Query(value = 	"select	f	" +
			   		"  from FederatedIdentifier f	" +
			   		"  join f.fedids_classes fc		" +
			   		"  join cl.theClass	cl			" +
			   		"  join cl.terms t				" +
			   		"  join t.term					" +
			   		" where cl.terms = ?1           ")
	public FederatedIdentifier findByFedIdClassTerm(String classTerm);
}
