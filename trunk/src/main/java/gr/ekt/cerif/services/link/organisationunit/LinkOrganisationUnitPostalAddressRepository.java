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
	
	OrganisationUnit_PostalAddress findByOrganisationUnitNameAndCountryName(String organisationUnitName, String cName);
	
	OrganisationUnit_PostalAddress findByOrganisationUnitName(String organisationUnitName);

	OrganisationUnit_PostalAddress findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String ccode);
	
	public OrganisationUnit_PostalAddress save(OrganisationUnit_PostalAddress entity);
	
	public Iterable<? extends OrganisationUnit_PostalAddress> save(Iterable<? extends OrganisationUnit_PostalAddress> entities);
	
	public void delete(OrganisationUnit_PostalAddress entity);
	
}
