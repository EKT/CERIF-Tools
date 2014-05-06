/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;

/**
 * @author bonisv
 *
 */
public interface OrganisationUnitResearchActivityRepository {

	public void delete(OrganisationUnitResearchActivity entity); 
	
	public void delete(Iterable<OrganisationUnitResearchActivity> entities); 

	public Iterable<OrganisationUnitResearchActivity> save(Iterable<OrganisationUnitResearchActivity> entities); 
	
	public OrganisationUnitResearchActivity save(OrganisationUnitResearchActivity entity);
	
	List<OrganisationUnitResearchActivity> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
