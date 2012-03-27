package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and classes.
 * 
 */
@Component
public class LinkEquipmentClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Equipment_Class entity) {
		if (entity.getEquipment() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a class.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Equipment_Class> entityList) {
		for (Equipment_Class entity : entityList) {
			save(entity);
		}
	}
	
}
