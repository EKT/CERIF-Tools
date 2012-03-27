package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between events and mediums.
 * 
 */
@Component
public class LinkEventMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Event_Medium entity) {
		if (entity.getEvent() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a event and a medium.");
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Event_Medium> entityList) {
		for (Event_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
