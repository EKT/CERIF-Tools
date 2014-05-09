/**
 * 
 */
package gr.ekt.cerif.services.second;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Currency;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for postal addresses.
 * 
 */
public interface CurrencyCrudRepository extends CrudRepository<Currency, String> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Currency findByCode(String code);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Currency findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Currency findByUuid(String uuid);

}
