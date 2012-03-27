package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and services.
 * 
 */
@Component
public class LinkEquipmentServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(Equipment_Service entity) {
		if (entity.getEquipment() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a service.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Equipment_Service> entityList) {
		for (Equipment_Service entity : entityList) {
			save(entity);
		}
	}
	
}
