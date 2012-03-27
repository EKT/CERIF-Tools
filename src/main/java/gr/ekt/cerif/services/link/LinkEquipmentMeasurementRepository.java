package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and measurements.
 * 
 */
@Component
public class LinkEquipmentMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Equipment_Measurement entity) {
		if (entity.getEquipment() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a measurement.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Equipment_Measurement> entityList) {
		for (Equipment_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
