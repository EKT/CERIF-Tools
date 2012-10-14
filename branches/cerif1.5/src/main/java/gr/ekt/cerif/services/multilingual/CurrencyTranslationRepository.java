/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.CurrencyTranslation;
import gr.ekt.cerif.services.second.CurrencyRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for currency translation entities.
 * 
 */
@Component
public class CurrencyTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(CurrencyTranslation entity) {
		if (entity.getCurrency() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a currency, a translation and a language.");
		}
		if (entity.getCurrency().getCode() == null) {
			currencyRepository.save(entity.getCurrency());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<CurrencyTranslation> entityList) {
		for (CurrencyTranslation entity : entityList) {
			save(entity);
		}
	}
}

