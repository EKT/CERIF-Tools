package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitPostalAddressCrudRepository extends CrudRepository<OrganisationUnit_PostalAddress, Long> {

	List<OrganisationUnit_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<OrganisationUnit_PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
}
