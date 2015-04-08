package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface FederatedIdentifierCrudRepository extends CrudRepository<FederatedIdentifier, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<FederatedIdentifier> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<FederatedIdentifier> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  join fedId.theClass cl            	"
			+ "  where cl.uri = ?1 and fedId.instanceId = ?2 ")
	public List<FederatedIdentifier> findFedIdByClassUriAndInstId(String classUri, Long instanceId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  join fedId.theClass cl            	"
			+ "  where cl.uuid = ?1 and fedId.instanceId = ?2 ")
	public List<FederatedIdentifier> findFedIdByClassUuidAndInstId(String classUuid, Long instanceId);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  left join fedId.theClass cl            	"
			+ "  left join fedId.scheme clsch           	"
			+ "  where cl = ?1 and clsch = ?2 and fedId.instanceId = ?3 and fedId.fedId = ?4 ")
	public List<FederatedIdentifier> findFedIdByClassClassSchemeInstIdAndFedId(Class theClass, ClassScheme classScheme, Long instanceId, String fedId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select fedId "
			+ "  from FederatedIdentifier fedId          	"
			+ "  left join fedId.theClass cl            	"
			+ "  left join fedId.scheme clsch           	"
			+ "  left join fedId.federatedIdentifiers_classes fedcls      "
			+ "  left join fedcls.theClass fedcl      "
			+ "  where cl = ?1 and clsch = ?2 and fedId.fedId = ?3 and fedcl = ?4 ")
	public List<FederatedIdentifier> findFedIdByClassClassSchemeAndFedId(Class theClass, ClassScheme classScheme, String fedId, Class fedType);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public FederatedIdentifier findByUuid(String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public FederatedIdentifier findById(Long id);
	
	
}