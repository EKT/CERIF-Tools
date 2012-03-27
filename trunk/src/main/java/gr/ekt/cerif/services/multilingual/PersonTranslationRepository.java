/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.PersonTranslation;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for project translation entities.
 * 
 */
@Component
public class PersonTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(PersonTranslation entity) {
		if (entity.getPerson() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a project, a translation and a language.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<PersonTranslation> entityList) {
		for (PersonTranslation entity : entityList) {
			save(entity);
		}
	}
}

