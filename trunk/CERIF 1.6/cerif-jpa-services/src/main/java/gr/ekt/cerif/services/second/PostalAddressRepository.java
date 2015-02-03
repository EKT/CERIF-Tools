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
	
	void delete(PostalAddress entity); 
	
	void delete(Iterable<PostalAddress> entities); 

	Iterable<PostalAddress> save(Iterable<PostalAddress> entities); 
	
	PostalAddress save(PostalAddress entity);
	
	List<PostalAddress> findByCountry(Country country);
	
	Iterable<PostalAddress> findAll();
	
	Page<PostalAddress> findAll(Pageable page);

	PostalAddress findByUuid(String uuid);
	
	PostalAddress findById(Long id);

	List<PostalAddress> findByUri(String uri);
	
	List<PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<PostalAddress> findByEquipment(Equipment equipment);
	
	List<PostalAddress> findByFacility(Facility facility);
	
	List<PostalAddress> findByService(Service service);

	List<PostalAddress> findByPerson(Person person);
}



