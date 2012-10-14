/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for postal addresses.
 * 
 */
public interface PostalAddressRepository extends CrudRepository<PostalAddress, String> {
	List<PostalAddress> findByCountry(Country country);	
}
