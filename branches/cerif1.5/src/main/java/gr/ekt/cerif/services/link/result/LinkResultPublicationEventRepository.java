package gr.ekt.cerif.services.link.result;

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
	
	private static final String QUERY1 =
			"select respubev from ResultPublication_Event respubev "+ 
			"  where respubev.id = :respubevId";

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
	
	/*
	 * Because the retrieving of the entity to be removed and the actual
	 * removing should be in the same transaction, prior to removing,
	 * the entity has to be re-retrieved even though the argument originates
	 * by an already retrieved entity. The argument comes from outside the 
	 * transaction thus being outside the current persistence context.
	 * Without the re-retrieving an IllegalArgumentException: Removing a 
	 * detached instance exception, will occur.
	 */
	@Transactional
	public void delete(ResultPublication_Event entity) {
		ResultPublication_Event respubev=queryResPubEventById(entity.getId());
		if (respubev!=null) { 
			entityManager.remove(respubev);
		}
	}
	
	@Transactional
	public void delete(List<ResultPublication_Event> entityList) {
		for (ResultPublication_Event entity : entityList) {
			delete(entity);
		}
	}
	
	public ResultPublication_Event queryResPubEventById(Long respubevId) {
		return entityManager.createQuery(QUERY1, ResultPublication_Event.class)
		.setParameter("respubevId", respubevId)
		.getSingleResult();
	}
	
}
