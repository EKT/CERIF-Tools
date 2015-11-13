/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface OrganisationUnitResearchActivityCrudRepository extends CrudRepository<OrganisationUnitResearchActivity, Long> {
	
	List<OrganisationUnitResearchActivity> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
