package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and events.
 * 
 */
@Component
public class LinkEquipmentEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(Equipment_Event entity) {
		if (entity.getEquipment() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a event.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Equipment_Event> entityList) {
		for (Equipment_Event entity : entityList) {
			save(entity);
		}
	}
	
}
