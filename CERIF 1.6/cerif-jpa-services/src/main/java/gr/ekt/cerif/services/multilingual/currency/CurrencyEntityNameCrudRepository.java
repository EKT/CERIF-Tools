/**
 * 
 */
package gr.ekt.cerif.services.multilingual.currency;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CurrencyEntityNameCrudRepository extends CrudRepository<CurrencyEntityName, Long> {
	
	List<CurrencyEntityName> findByCurrency(Currency currency);

}
