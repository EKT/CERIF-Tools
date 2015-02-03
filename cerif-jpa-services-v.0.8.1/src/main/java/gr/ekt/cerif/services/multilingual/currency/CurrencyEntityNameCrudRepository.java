/**
 * 
 */
package gr.ekt.cerif.services.multilingual.currency;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CurrencyEntityNameCrudRepository extends CrudRepository<CurrencyEntityName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CurrencyEntityName> findByCurrency(Currency currency);

}
