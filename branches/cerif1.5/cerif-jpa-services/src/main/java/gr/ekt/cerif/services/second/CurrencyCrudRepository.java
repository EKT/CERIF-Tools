/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Currency;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for postal addresses.
 * 
 */
public interface CurrencyCrudRepository extends CrudRepository<Currency, String> {

}
