/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import org.springframework.data.repository.CrudRepository;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitRepository extends CrudRepository<OrganisationUnit, Long> {

	OrganisationUnit findByUri(String uri);
	
	OrganisationUnit findByAcronym(String acronym);
}
