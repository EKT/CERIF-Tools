/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface OrganisationUnitKeywordCrudRepository extends CrudRepository<OrganisationUnitKeyword, Long> {
	
	List<OrganisationUnitKeyword> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
