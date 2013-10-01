package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitFacilityCrudRepository extends CrudRepository<OrganisationUnit_Facility, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_Facility> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
