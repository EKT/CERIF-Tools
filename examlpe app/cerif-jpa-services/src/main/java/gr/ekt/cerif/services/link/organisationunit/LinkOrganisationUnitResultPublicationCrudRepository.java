package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitResultPublicationCrudRepository extends CrudRepository<OrganisationUnit_ResultPublication, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_ResultPublication> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_ResultPublication> findByResultPublication(ResultPublication resultPublication);
		
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select orgunitrespub from OrganisationUnit_ResultPublication orgunitrespub "+ 
			"  where orgunitrespub.id = ?1  ")
	OrganisationUnit_ResultPublication findById(Long orgunitrespubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select ourp from OrganisationUnit_ResultPublication ourp "+
		    "  join ourp.resultPublication rp "+
			"  join ourp.organisationUnit ou "+
			"  where ou.id = ?1 and rp.id=?2 ")
	OrganisationUnit_ResultPublication findByOrganisationUnitIdAndResultPublicationId(Long ouId, Long resId);	

}
