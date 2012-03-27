/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.PrizeTranslation;
import gr.ekt.cerif.services.second.PrizeRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for prize translation entities.
 * 
 */
@Component
public class PrizeTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	PrizeRepository prizeRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(PrizeTranslation entity) {
		if (entity.getPrize() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a prize, a translation and a language.");
		}
		if (entity.getPrize().getId() == null) {
			prizeRepository.save(entity.getPrize());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<PrizeTranslation> entityList) {
		for (PrizeTranslation entity : entityList) {
			save(entity);
		}
	}
}

