/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

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
}
