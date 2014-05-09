package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.FederatedIdentifier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface FederatedIdentifierCrudRepository extends CrudRepository<FederatedIdentifier, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<FederatedIdentifier> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Page<FederatedIdentifier> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  join fedId.theClass cl            	"
			+ "  where cl.uri = ?1 and fedId.instanceId = ?2 ")
	List<FederatedIdentifier> findFedIdByClassUriAndInstId(String classUri, Long instanceId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  join fedId.theClass cl            	"
			+ "  where cl.uuid = ?1 and fedId.instanceId = ?2 ")
	List<FederatedIdentifier> findFedIdByClassUuidAndInstId(String classUuid, Long instanceId);
	
	
}