/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;

/**
 * @author bonisv
 *
 */
public interface ElectronicAddressRepository {
	
	ElectronicAddress findById(Long id);
	
	ElectronicAddress findByUri(String uri);
	
	List<ElectronicAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<ElectronicAddress> findByPerson(Person person);

	void delete(ElectronicAddress entity); 
	
	void delete(Iterable<ElectronicAddress> entities); 

	Iterable<ElectronicAddress> save(Iterable<ElectronicAddress> entities); 
	
	ElectronicAddress save(ElectronicAddress entity);
	
	Iterable<ElectronicAddress> findAll();
	
	Page<ElectronicAddress> findAll(Pageable page);
	
	ElectronicAddress findByUUID(String uuid);

}
