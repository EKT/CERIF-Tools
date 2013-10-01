/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for electronic addresses.
 * 
 */
public interface ElectronicAddressCrudRepository extends CrudRepository<ElectronicAddress, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ElectronicAddress findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select ea from ElectronicAddress ea " +
			"join ea.organisationUnits orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
    ElectronicAddress findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
