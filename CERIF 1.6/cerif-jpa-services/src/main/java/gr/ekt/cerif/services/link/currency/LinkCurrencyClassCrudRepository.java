package gr.ekt.cerif.services.link.currency;

import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkCurrencyClassCrudRepository extends CrudRepository<Currency_Class, Long> {
	
	List<Currency_Class> findByCurrency(Currency currency);
	
	List<Currency_Class> findBytheClass(Class theClass);

}
