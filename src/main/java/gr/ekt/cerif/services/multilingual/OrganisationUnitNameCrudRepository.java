package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for organisation unit name entities.
 * 
 * 
 */
public interface OrganisationUnitNameCrudRepository extends CrudRepository<OrganisationUnitName, Long> {

	OrganisationUnitName findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
