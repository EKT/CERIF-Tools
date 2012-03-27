package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and events.
 * 
 */
@Component
public class LinkResultPublicationEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(ResultPublication_Event entity) {
		if (entity.getResultPublication() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a event.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Event> entityList) {
		for (ResultPublication_Event entity : entityList) {
			save(entity);
		}
	}
	
}
