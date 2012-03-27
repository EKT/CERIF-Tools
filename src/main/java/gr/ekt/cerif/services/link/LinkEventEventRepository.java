package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between events.
 * 
 */
@Component
public class LinkEventEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(Event_Event entity) {
		if (entity.getEvent1() == null || entity.getEvent2() == null) {
			throw new IllegalArgumentException("Please provide both events.");
		}
		if (entity.getEvent1().getId() == null) {
			eventRepository.save(entity.getEvent1());
		}
		if (entity.getEvent2().getId() == null) {
			eventRepository.save(entity.getEvent2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Event_Event> entityList) {
		for (Event_Event entity : entityList) {
			save(entity);
		}
	}
	
}
