/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;

/**
 * @author bonisv
 *
 */
public interface OrganisationUnitKeywordRepository {

	public void delete(OrganisationUnitKeyword entity); 
	
	public void delete(Iterable<OrganisationUnitKeyword> entities); 

	public Iterable<OrganisationUnitKeyword> save(Iterable<OrganisationUnitKeyword> entities); 
	
	public OrganisationUnitKeyword save(OrganisationUnitKeyword entity);
	
	List<OrganisationUnitKeyword> findByOrganisationUnit(OrganisationUnit organisationUnit);
}
