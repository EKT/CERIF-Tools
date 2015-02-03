/**
 * 
 */
package gr.ekt.cerif.services.multilingual.currency;

import java.util.List;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;

/**
 * @author bonisv
 *
 */
public interface CurrencyEntityNameRepository {
	
	public void delete(CurrencyEntityName entity); 
	
	public void delete(Iterable<CurrencyEntityName> entities); 

	public Iterable<CurrencyEntityName> save(Iterable<CurrencyEntityName> entities); 
	
	public CurrencyEntityName save(CurrencyEntityName entity);
	
	List<CurrencyEntityName> findByCurrency(Currency currency);

}
