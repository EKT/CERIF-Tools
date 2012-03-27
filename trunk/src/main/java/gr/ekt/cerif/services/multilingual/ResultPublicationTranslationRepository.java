/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ResultPublicationTranslation;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for result publication translation entities.
 * 
 */
@Component
public class ResultPublicationTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ResultPublicationTranslation entity) {
		if (entity.getResultPublication() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a result publication, a translation and a language.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublicationTranslation> entityList) {
		for (ResultPublicationTranslation entity : entityList) {
			save(entity);
		}
	}
}
