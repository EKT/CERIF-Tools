/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Country;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for countries.
 * 
 */
public interface CountryRepository extends CrudRepository<Country, String> {

}
