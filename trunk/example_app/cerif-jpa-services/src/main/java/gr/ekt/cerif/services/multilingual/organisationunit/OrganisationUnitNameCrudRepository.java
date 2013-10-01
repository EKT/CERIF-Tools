package gr.ekt.cerif.services.multilingual.organisationunit;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for organisation unit name entities.
 * 
 * 
 */
public interface OrganisationUnitNameCrudRepository extends CrudRepository<OrganisationUnitName, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	OrganisationUnitName findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
