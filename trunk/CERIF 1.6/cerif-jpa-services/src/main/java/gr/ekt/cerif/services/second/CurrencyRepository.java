/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Currency;

/**
 * A repository for Currency.
 * @author bonisv
 *
 */
public interface CurrencyRepository {

	void delete(Currency entity); 
	
	void delete(Iterable<Currency> entities); 

	Iterable<Currency> save(Iterable<Currency> entities); 
	
	Currency save(Currency entity);
	
	Currency findByCode(String code);
	
	Currency findByUri(String uri);
	
	Currency findByUuid(String uuid);
	
	List<Currency> findAll();
	
	Page<Currency> findAll(Pageable page);
}
