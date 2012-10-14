package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and events.
 * 
 */
@Component
public class LinkPersonEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(Person_Event entity) {
		if (entity.getPerson() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a person and a event.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Event> entityList) {
		for (Person_Event entity : entityList) {
			save(entity);
		}
	}
	
}
