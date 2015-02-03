/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for mediums.
 * 
 */
public interface MediumCrudRepository extends CrudRepository<Medium, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Medium findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Medium findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	m	" +
			   "  from Medium m " +
			   "  left join m.projects_mediums projm	" +
			   "  left join projm.project proj	" +
			   "  left join projm.theClass cl	" +
			   " where proj.id = ?1 and cl.uuid = ?2    ")
	public Medium findMediumByProjectIdAndClassUUID(Long id, String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	m	" +
			   "  from Medium m " +
			   "  left join m.organisationUnits_mediums orgm	" +
			   "  left join orgm.organisationUnit org	" +
			   "  left join orgm.theClass cl	" +
			   " where org.id = ?1 and cl.uuid = ?2    ")
	public Medium findMediumByOrgIdAndClassUUID(Long id, String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	m	" +
			   "  from Medium m " +
			   "  left join m.persons_mediums persm	" +
			   "  left join persm.person pers	" +
			   "  left join persm.theClass cl	" +
			   " where pers.id = ?1 and cl.uuid = ?2    ")
	public Medium findMediumByPersonIdAndClassUUID(Long id, String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Medium> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Medium> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Medium findByUuid(String uuid);
	
}
