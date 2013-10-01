package gr.ekt.cerif.services.link.currency;

import gr.ekt.cerif.entities.link.Currency_Class;

/**
 * A repository for links between currencys and classes.
 * 
 */
public interface LinkCurrencyClassRepository {

	public void delete(Currency_Class entity); 
	
	public void delete(Iterable<Currency_Class> entities); 

	public Iterable<Currency_Class> save(Iterable<Currency_Class> entities); 
	
	public Currency_Class save(Currency_Class entity);
	
}
