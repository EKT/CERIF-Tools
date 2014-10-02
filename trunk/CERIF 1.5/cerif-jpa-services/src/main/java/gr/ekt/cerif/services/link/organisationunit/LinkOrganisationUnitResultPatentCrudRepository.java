package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitResultPatentCrudRepository extends CrudRepository<OrganisationUnit_ResultPatent, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_ResultPatent> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
