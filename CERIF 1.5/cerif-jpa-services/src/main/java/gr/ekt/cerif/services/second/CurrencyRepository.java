/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Currency;

/**
 * A repository for Currency.
 * @author bonisv
 *
 */
public interface CurrencyRepository {

	public void delete(Currency entity); 
	
	public void delete(Iterable<Currency> entities); 

	public Iterable<Currency> save(Iterable<Currency> entities); 
	
	public Currency save(Currency entity);
	
	Currency findByCode(String code);
	
	Currency findByUri(String uri);
	
	Currency findByUuid(String uuid);
}
