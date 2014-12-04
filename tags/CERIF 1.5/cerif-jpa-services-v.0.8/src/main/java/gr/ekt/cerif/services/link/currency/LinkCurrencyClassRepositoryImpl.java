package gr.ekt.cerif.services.link.currency;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkCurrencyClassRepositoryImpl implements
		LinkCurrencyClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkCurrencyClassRepositoryImpl.class);
	
	@Autowired
	private LinkCurrencyClassCrudRepository linkCurrencyClassCrudRepository;

	@Override
	public void delete(Currency_Class entity) {
		linkCurrencyClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Currency_Class> entities) {
		linkCurrencyClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Currency_Class> save(Iterable<Currency_Class> entities) {
		return linkCurrencyClassCrudRepository.save(entities);
	}

	@Override
	public Currency_Class save(Currency_Class entity) {
		return linkCurrencyClassCrudRepository.save(entity);
	}

	@Override
	public List<Currency_Class> findByCurrency(Currency currency) {
		return linkCurrencyClassCrudRepository.findByCurrency(currency);
	}

	@Override
	public List<Currency_Class> findBytheClass(Class theClass) {
		return linkCurrencyClassCrudRepository.findBytheClass(theClass);
	}

}
