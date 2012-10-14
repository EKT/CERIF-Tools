package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and events.
 * 
 */
@Component
public class LinkFacilityEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(Facility_Event entity) {
		if (entity.getFacility() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a event.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Event> entityList) {
		for (Facility_Event entity : entityList) {
			save(entity);
		}
	}
	
}
