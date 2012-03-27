/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ResultPatentTranslation;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for result patent translation entities.
 * 
 */
@Component
public class ResultPatentTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ResultPatentRepository resultPatentRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ResultPatentTranslation entity) {
		if (entity.getResultPatent() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a result patent, a translation and a language.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatentTranslation> entityList) {
		for (ResultPatentTranslation entity : entityList) {
			save(entity);
		}
	}
}
