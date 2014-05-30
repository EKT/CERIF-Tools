/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import java.util.List;

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
	Page<OrganisationUnit> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select o from gr.ekt.cerif.entities.base.OrganisationUnit o where o.id = ?1")
	OrganisationUnit findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select o from gr.ekt.cerif.entities.base.OrganisationUnit o where o.id in ?1")
	List<OrganisationUnit> findById(List<Long> ids);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	OrganisationUnit findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	OrganisationUnit findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value="select o from gr.ekt.cerif.entities.base.OrganisationUnit o join o.organisationUnitNames oname where oname.name= ?1 ")
	OrganisationUnit findByOrganisationUnitName(String organisationUnitName);
	
	OrganisationUnit findByUuid(String uuid);

}
