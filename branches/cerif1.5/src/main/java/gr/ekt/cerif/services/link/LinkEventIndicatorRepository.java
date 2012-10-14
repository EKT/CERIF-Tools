package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between events and indicators.
 * 
 */
@Component
public class LinkEventIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Event_Indicator entity) {
		if (entity.getEvent() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a event and a indicator.");
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Event_Indicator> entityList) {
		for (Event_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
