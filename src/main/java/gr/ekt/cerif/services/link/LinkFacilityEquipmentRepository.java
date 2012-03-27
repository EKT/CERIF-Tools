package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and equipments.
 * 
 */
@Component
public class LinkFacilityEquipmentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Transactional
	public void save(Facility_Equipment entity) {
		if (entity.getFacility() == null || entity.getEquipment() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a equipment.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Equipment> entityList) {
		for (Facility_Equipment entity : entityList) {
			save(entity);
		}
	}
	
}
