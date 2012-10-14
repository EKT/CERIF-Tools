/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ResultProductTranslation;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for result product translation entities.
 * 
 */
@Component
public class ResultProductTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ResultProductRepository resultProductRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ResultProductTranslation entity) {
		if (entity.getResultProduct() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a result product, a translation and a language.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProductTranslation> entityList) {
		for (ResultProductTranslation entity : entityList) {
			save(entity);
		}
	}
}
