package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and equipments.
 * 
 */
@Component
public class LinkResultPatentEquipmentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Transactional
	public void save(ResultPatent_Equipment entity) {
		if (entity.getResultPatent() == null || entity.getEquipment() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a equipment.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Equipment> entityList) {
		for (ResultPatent_Equipment entity : entityList) {
			save(entity);
		}
	}
	
}
