/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.CountryTranslation;
import gr.ekt.cerif.services.second.CountryRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for country translation entities.
 * 
 */
@Component
public class CountryTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(CountryTranslation entity) {
		if (entity.getCountry() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a country, a translation and a language.");
		}
		if (entity.getCountry().getCode() == null) {
			countryRepository.save(entity.getCountry());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<CountryTranslation> entityList) {
		for (CountryTranslation entity : entityList) {
			save(entity);
		}
	}
}

