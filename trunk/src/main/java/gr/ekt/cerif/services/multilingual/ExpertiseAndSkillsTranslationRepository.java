/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsTranslation;
import gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for expertiseAndSkills translation entities.
 * 
 */
@Component
public class ExpertiseAndSkillsTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ExpertiseAndSkillsRepository expertiseAndSkillsRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ExpertiseAndSkillsTranslation entity) {
		if (entity.getExpertiseAndSkills() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a expertiseAndSkills, a translation and a language.");
		}
		if (entity.getExpertiseAndSkills().getId() == null) {
			expertiseAndSkillsRepository.save(entity.getExpertiseAndSkills());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ExpertiseAndSkillsTranslation> entityList) {
		for (ExpertiseAndSkillsTranslation entity : entityList) {
			save(entity);
		}
	}
}

