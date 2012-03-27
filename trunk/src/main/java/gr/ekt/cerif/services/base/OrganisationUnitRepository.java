/**
 * 
 */
package gr.ekt.cerif.services.base;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitRepository {

	/**
	 * Saves the provided organisation.
	 * @param organisation
	 */
	void save(OrganisationUnit organisation);

	/**
	 * Saves the provided list of organisations.
	 * @param organisationList
	 */
	void save(List<OrganisationUnit> organisationList);

}
