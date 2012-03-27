package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between events and measurements.
 * 
 */
@Component
public class LinkEventMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Event_Measurement entity) {
		if (entity.getEvent() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a event and a measurement.");
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Event_Measurement> entityList) {
		for (Event_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
