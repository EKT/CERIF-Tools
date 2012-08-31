/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for electronic addresses.
 * 
 */
public interface ElectronicAddressRepository extends CrudRepository<ElectronicAddress, Long> {
	ElectronicAddress findByUri(String uri);
	
	
}
