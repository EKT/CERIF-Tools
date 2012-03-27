/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.QualificationTranslation;
import gr.ekt.cerif.services.second.QualificationRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for qualification translation entities.
 * 
 */
@Component
public class QualificationTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	QualificationRepository qualificationRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(QualificationTranslation entity) {
		if (entity.getQualification() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a qualification, a translation and a language.");
		}
		if (entity.getQualification().getId() == null) {
			qualificationRepository.save(entity.getQualification());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<QualificationTranslation> entityList) {
		for (QualificationTranslation entity : entityList) {
			save(entity);
		}
	}
}

