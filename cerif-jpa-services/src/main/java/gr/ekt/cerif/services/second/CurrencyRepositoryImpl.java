/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Currency;

/**
 * @author bonisv
 *
 */
@Component
public class CurrencyRepositoryImpl implements CurrencyRepository {

	private static final Logger log = LoggerFactory.getLogger(CurrencyRepositoryImpl.class);
	
	@Autowired
	private CurrencyCrudRepository currencyCrudRepository;
	
	@Override
	public void delete(Currency entity) {
		currencyCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Currency> entities) {
		currencyCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Currency> save(Iterable<Currency> entities) {
		return currencyCrudRepository.save(entities);
	}

	@Override
	public Currency save(Currency entity) {
		return currencyCrudRepository.save(entity);
	}

}
