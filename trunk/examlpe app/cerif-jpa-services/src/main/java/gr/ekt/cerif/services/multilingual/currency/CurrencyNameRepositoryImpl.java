/**
 * 
 */
package gr.ekt.cerif.services.multilingual.currency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.CurrencyName;


/**
 * @author bonisv
 *
 */
@Component
public class CurrencyNameRepositoryImpl implements CurrencyNameRepository{

	private static final Logger log = LoggerFactory.getLogger(CurrencyNameRepositoryImpl.class);
	
	@Autowired
	private CurrencyNameCrudRepository currencyNameCrudRepository;
	
	@Override
	public void delete(CurrencyName entity) {
		currencyNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<CurrencyName> entities) {
		currencyNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<CurrencyName> save(Iterable<CurrencyName> entities) {
		return currencyNameCrudRepository.save(entities);
	}

	@Override
	public CurrencyName save(CurrencyName entity) {
		return currencyNameCrudRepository.save(entity);
	}

}
