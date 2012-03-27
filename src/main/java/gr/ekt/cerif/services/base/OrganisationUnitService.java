/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 */
public interface OrganisationUnitService extends JpaRepository<OrganisationUnit, Long> {

	OrganisationUnit findByUri(String uri);
	
}
