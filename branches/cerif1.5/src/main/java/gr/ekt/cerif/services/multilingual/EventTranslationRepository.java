/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.EventTranslation;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for event translation entities.
 * 
 */
@Component
public class EventTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(EventTranslation entity) {
		if (entity.getEvent() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a event, a translation and a language.");
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<EventTranslation> entityList) {
		for (EventTranslation entity : entityList) {
			save(entity);
		}
	}
}

