package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Equipment;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and equipments.
 * 
 */
@Component
public class LinkEquipmentEquipmentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Transactional
	public Equipment_Equipment save(Equipment_Equipment entity) {
		if (entity.getEquipment1() == null || entity.getEquipment2() == null) {
			throw new IllegalArgumentException("Please provide both equipments.");
		}
		if (entity.getEquipment1().getId() == null) {
			equipmentRepository.save(entity.getEquipment1());
		}
		if (entity.getEquipment2().getId() == null) {
			equipmentRepository.save(entity.getEquipment2());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<Equipment_Equipment> save(Iterable<Equipment_Equipment> entityList) {
		for (Equipment_Equipment entity : entityList) {
			save(entity);
		}
		return entityList;
	}
	
}
