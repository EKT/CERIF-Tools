package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts and equipments.
 * 
 */
@Component
public class LinkResultProductEquipmentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Transactional
	public void save(ResultProduct_Equipment entity) {
		if (entity.getResultProduct() == null || entity.getEquipment() == null) {
			throw new IllegalArgumentException("Please provide both a resultProduct and a equipment.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Equipment> entityList) {
		for (ResultProduct_Equipment entity : entityList) {
			save(entity);
		}
	}
	
}
