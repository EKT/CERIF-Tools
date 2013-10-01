/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

/**
 * A repository for postal addresses.
 * 
 */
public interface PostalAddressRepository {
	
	List<PostalAddress> findByCountry(Country country);
	
    PostalAddress findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String ccode);

	List<PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);

	PostalAddress findByOrganisationUnitAndCountryCode(OrganisationUnit organisationUnit, String ccode);

	PostalAddress findByPerson(Person person);
	
	PostalAddress findByOrganisationUnitName(String organisationUnitName);
	
	public void delete(PostalAddress entity); 
	
	public void delete(Iterable<PostalAddress> entities); 

	public Iterable<PostalAddress> save(Iterable<PostalAddress> entities); 
	
	public PostalAddress save(PostalAddress entity);
	
}



