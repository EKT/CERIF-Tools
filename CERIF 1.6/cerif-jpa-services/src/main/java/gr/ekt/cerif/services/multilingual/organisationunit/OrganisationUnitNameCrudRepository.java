package gr.ekt.cerif.services.multilingual.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for organisation unit name entities.
 * 
 * 
 */
public interface OrganisationUnitNameCrudRepository extends CrudRepository<OrganisationUnitName, Long> {

	List<OrganisationUnitName> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
