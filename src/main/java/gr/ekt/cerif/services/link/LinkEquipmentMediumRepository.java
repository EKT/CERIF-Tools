package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and mediums.
 * 
 */
@Component
public class LinkEquipmentMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Equipment_Medium entity) {
		if (entity.getEquipment() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a medium.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Equipment_Medium> entityList) {
		for (Equipment_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
