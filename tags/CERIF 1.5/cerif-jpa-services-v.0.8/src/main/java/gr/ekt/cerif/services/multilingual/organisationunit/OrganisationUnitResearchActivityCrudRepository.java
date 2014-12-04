/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface OrganisationUnitResearchActivityCrudRepository extends CrudRepository<OrganisationUnitResearchActivity, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnitResearchActivity> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
