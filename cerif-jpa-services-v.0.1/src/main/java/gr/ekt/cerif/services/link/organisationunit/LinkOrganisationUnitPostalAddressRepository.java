package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

/**
 * A repository for links between organisation units and postal addresses.
 * 
 */
public interface LinkOrganisationUnitPostalAddressRepository {
	
	List<OrganisationUnit_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<OrganisationUnit_PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	OrganisationUnit_PostalAddress save(OrganisationUnit_PostalAddress entity);
	
	Iterable<OrganisationUnit_PostalAddress> save(Iterable<OrganisationUnit_PostalAddress> entities);
	
	void delete(OrganisationUnit_PostalAddress entity);
	
	void delete(Iterable<? extends OrganisationUnit_PostalAddress> entityList);
	
}
