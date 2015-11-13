package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FederatedIdentifierCrudRepository extends CrudRepository<FederatedIdentifier, Long> {
	
	public List<FederatedIdentifier> findAll();
	
	public Page<FederatedIdentifier> findAll(Pageable page);

	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  join fedId.theClass cl            	"
			+ "  where cl.uri = ?1 and fedId.instanceId = ?2 ")
	public List<FederatedIdentifier> findFedIdByClassUriAndInstId(String classUri, Long instanceId);
	
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  join fedId.theClass cl            	"
			+ "  where cl.uuid = ?1 and fedId.instanceId = ?2 ")
	public List<FederatedIdentifier> findFedIdByClassUuidAndInstId(String classUuid, Long instanceId);

	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  left join fedId.theClass cl            	"
			+ "  left join fedId.scheme clsch           	"
			+ "  where cl = ?1 and clsch = ?2 and fedId.instanceId = ?3 and fedId.fedId = ?4 ")
	public List<FederatedIdentifier> findFedIdByClassClassSchemeInstIdAndFedId(Class theClass, ClassScheme classScheme, Long instanceId, String fedId);
	
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  left join fedId.theClass cl            	"
			+ "  left join fedId.federatedIdentifiers_classes fedcls      "
			+ "  left join fedcls.theClass fedcl      "
			+ "  where cl = ?1 and fedId.fedId = ?2 and fedcl = ?3 ")
	public List<FederatedIdentifier> findFedIdByClassClassSchemeAndFedId(Class entityClass, String fedId, Class fedClass);
	
	public FederatedIdentifier findByUuid(String uuid);
	
	public FederatedIdentifier findById(Long id);
	
	
}