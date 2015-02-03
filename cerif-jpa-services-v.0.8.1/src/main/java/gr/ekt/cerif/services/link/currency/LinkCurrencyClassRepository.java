package gr.ekt.cerif.services.link.currency;

import java.util.List;

import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between currencies and classes.
 * 
 */
public interface LinkCurrencyClassRepository {

	public void delete(Currency_Class entity); 
	
	public void delete(Iterable<Currency_Class> entities); 

	public Iterable<Currency_Class> save(Iterable<Currency_Class> entities); 
	
	public Currency_Class save(Currency_Class entity);
	
	List<Currency_Class> findByCurrency(Currency currency);
	
	List<Currency_Class> findBytheClass(Class theClass);
	
}
