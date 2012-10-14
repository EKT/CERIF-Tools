/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.FundingTranslation;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for funding translation entities.
 * 
 */
@Component
public class FundingTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	FundingRepository fundingRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(FundingTranslation entity) {
		if (entity.getFunding() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a funding, a translation and a language.");
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<FundingTranslation> entityList) {
		for (FundingTranslation entity : entityList) {
			save(entity);
		}
	}
}

