package gr.ekt.cerif.services.link.currency;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkCurrencyClassCrudRepository extends CrudRepository<Currency_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Currency_Class> findByCurrency(Currency currency);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Currency_Class> findBytheClass(Class theClass);

}
