package gr.ekt.cerif.services.multilingual.currency;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.multilingual.CurrencyName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CurrencyNameCrudRepository extends CrudRepository<CurrencyName, Long> {
	
	List<CurrencyName> findByCurrency(Currency currency);

}
