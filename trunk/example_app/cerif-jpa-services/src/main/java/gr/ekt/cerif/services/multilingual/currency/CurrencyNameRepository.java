/**
 * 
 */
package gr.ekt.cerif.services.multilingual.currency;

import gr.ekt.cerif.features.multilingual.CurrencyName;

/**
 * @author bonisv
 *
 */
public interface CurrencyNameRepository {
	
	public void delete(CurrencyName entity); 
	
	public void delete(Iterable<CurrencyName> entities); 

	public Iterable<CurrencyName> save(Iterable<CurrencyName> entities); 
	
	public CurrencyName save(CurrencyName entity);

}
