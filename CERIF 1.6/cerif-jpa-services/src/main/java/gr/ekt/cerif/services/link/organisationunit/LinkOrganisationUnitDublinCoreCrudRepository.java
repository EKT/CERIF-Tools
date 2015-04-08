package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_DublinCore;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitDublinCoreCrudRepository extends CrudRepository<OrganisationUnit_DublinCore, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_DublinCore> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
