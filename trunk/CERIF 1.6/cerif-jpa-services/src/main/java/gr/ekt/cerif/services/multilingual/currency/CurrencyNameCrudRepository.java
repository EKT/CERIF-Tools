package gr.ekt.cerif.services.multilingual.currency;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.multilingual.CurrencyName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyNameCrudRepository extends CrudRepository<CurrencyName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CurrencyName> findByCurrency(Currency currency);

}
