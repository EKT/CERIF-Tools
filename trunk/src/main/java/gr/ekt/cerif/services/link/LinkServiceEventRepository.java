package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and eventes.
 * 
 */
@Component
public class LinkServiceEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(Service_Event entity) {
		if (entity.getService() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a service and a event.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Event> entityList) {
		for (Service_Event entity : entityList) {
			save(entity);
		}
	}
	
}
