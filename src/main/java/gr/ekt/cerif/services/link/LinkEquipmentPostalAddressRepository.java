package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and postalAddresses.
 * 
 */
@Component
public class LinkEquipmentPostalAddressRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Transactional
	public void save(Equipment_PostalAddress entity) {
		if (entity.getEquipment() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a postalAddress.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getPostalAddress().getId() == null) {
			postalAddressRepository.save(entity.getPostalAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Equipment_PostalAddress> entityList) {
		for (Equipment_PostalAddress entity : entityList) {
			save(entity);
		}
	}
	
}
