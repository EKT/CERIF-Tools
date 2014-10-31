/**
 * 
 */
package gr.ekt.cerif.services.multilingual.currency;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;

/**
 * @author bonisv
 *
 */
@Component
public class CurrencyEntityNameRepositoryImpl implements CurrencyEntityNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyEntityNameRepositoryImpl.class);
	
	@Autowired
	private CurrencyEntityNameCrudRepository currencyEntityNameCrudRepository;

	@Override
	public void delete(CurrencyEntityName entity) {
		currencyEntityNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<CurrencyEntityName> entities) {
		currencyEntityNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<CurrencyEntityName> save(Iterable<CurrencyEntityName> entities) {
		return currencyEntityNameCrudRepository.save(entities);
	}

	@Override
	public CurrencyEntityName save(CurrencyEntityName entity) {
		return currencyEntityNameCrudRepository.save(entity);
	}

	@Override
	public List<CurrencyEntityName> findByCurrency(Currency currency) {
		return currencyEntityNameCrudRepository.findByCurrency(currency);
	}

}
