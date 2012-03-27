package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.services.second.CurrencyRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between currencys and classes.
 * 
 */
@Component
public class LinkCurrencyClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Currency_Class entity) {
		if (entity.getCurrency() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a currency and a class.");
		}
		if (entity.getCurrency().getCode() == null) {
			currencyRepository.save(entity.getCurrency());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Currency_Class> entityList) {
		for (Currency_Class entity : entityList) {
			save(entity);
		}
	}
	
}
