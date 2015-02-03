/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitCrudRepository extends CrudRepository<OrganisationUnit, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Iterable<OrganisationUnit> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<OrganisationUnit> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public OrganisationUnit findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public OrganisationUnit findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public OrganisationUnit findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public OrganisationUnit findByUuid(String uuid);
	
	@Query(
		"select o " +
		"  from OrganisationUnit o " +
		"  left join fetch o.organisationUnitNames " +
		"  left join fetch o.organisationUnitKeywords " +
		"  left join fetch o.organisationUnitResearchActivities " +
		" where o.uuid = ?1 ")
	OrganisationUnit findByUuidFetchMultilingual(String uuid);

}
