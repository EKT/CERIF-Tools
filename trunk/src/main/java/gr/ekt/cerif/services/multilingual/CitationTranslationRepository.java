/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.CitationTranslation;
import gr.ekt.cerif.services.second.CitationRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for citation translation entities.
 * 
 */
@Component
public class CitationTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	CitationRepository citationRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(CitationTranslation entity) {
		if (entity.getCitation() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a citation, a translation and a language.");
		}
		if (entity.getCitation().getId() == null) {
			citationRepository.save(entity.getCitation());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<CitationTranslation> entityList) {
		for (CitationTranslation entity : entityList) {
			save(entity);
		}
	}
}

