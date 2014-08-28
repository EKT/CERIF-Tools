/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

/**
 * A repository for postal addresses.
 * 
 */
public interface PostalAddressRepository {
	
	PostalAddress findById(Long id);
	
	List<PostalAddress> findByCountry(Country country);
	
    PostalAddress findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String ccode);

	List<PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<PostalAddress> findByEquipment(Equipment equipment);
	
	List<PostalAddress> findByFacility(Facility facility);
	
	List<PostalAddress> findByService(Service service);

	PostalAddress findByOrganisationUnitAndCountryCode(OrganisationUnit organisationUnit, String ccode);

	List<PostalAddress> findByPerson(Person person);
	
	PostalAddress findByOrganisationUnitName(String organisationUnitName);
	
	public void delete(PostalAddress entity); 
	
	public void delete(Iterable<PostalAddress> entities); 

	public Iterable<PostalAddress> save(Iterable<PostalAddress> entities); 
	
	public PostalAddress save(PostalAddress entity);
	
	Iterable<PostalAddress> findAll();
	
	Page<PostalAddress> findAll(Pageable page);
	
	PostalAddress findByUUID(String uuid);
	
}



