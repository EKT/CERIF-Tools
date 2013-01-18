package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and indicators.
 * 
 */
@Component
public class LinkEquipmentIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public Equipment_Indicator save(Equipment_Indicator entity) {
		if (entity.getEquipment() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a indicator.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<Equipment_Indicator> save(Iterable<Equipment_Indicator> entityList) {
		for (Equipment_Indicator entity : entityList) {
			save(entity);
		}
		return entityList;
	}
	
}
