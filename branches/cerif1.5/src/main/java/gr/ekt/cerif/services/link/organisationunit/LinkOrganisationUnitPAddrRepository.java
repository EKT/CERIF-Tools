package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between organisation units and postal addresses.
 * 
 */
public interface LinkOrganisationUnitPAddrRepository extends CrudRepository<OrganisationUnit_PostalAddress, Long>{
	OrganisationUnit_PostalAddress findByPostalAddress(PostalAddress postalAddress);
	
	OrganisationUnit_PostalAddress findByOrganisationUnit(OrganisationUnit organisationUnit);		
}
