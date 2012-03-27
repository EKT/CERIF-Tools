package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between countries and classes.
 * 
 */
@Component
public class LinkEventClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Event_Class entity) {
		if (entity.getEvent() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a event and a class.");
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Event_Class> entityList) {
		for (Event_Class entity : entityList) {
			save(entity);
		}
	}
	
}
