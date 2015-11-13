/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitCrudRepository extends CrudRepository<OrganisationUnit, Long> {

	Iterable<OrganisationUnit> findAll();
	
	Page<OrganisationUnit> findAll(Pageable page);
	
	OrganisationUnit findById(Long id);
	
	OrganisationUnit findByUri(String uri);
	
	OrganisationUnit findByUuid(String uuid);
	
	OrganisationUnit findByAcronym(String acronym);
	
	@Query(
		"select o " +
		"  from OrganisationUnit o " +
		"  left join fetch o.organisationUnitNames " +
		"  left join fetch o.organisationUnitKeywords " +
		"  left join fetch o.organisationUnitResearchActivities " +
		" where o.uuid = ?1 ")
	OrganisationUnit findByUuidFetchMultilingual(String uuid);
	
	

}
