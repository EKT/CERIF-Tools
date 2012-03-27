package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and equipments.
 * 
 */
@Component
public class LinkPersonEquipmentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Transactional
	public void save(Person_Equipment entity) {
		if (entity.getPerson() == null || entity.getEquipment() == null) {
			throw new IllegalArgumentException("Please provide both a person and a equipment.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Equipment> entityList) {
		for (Person_Equipment entity : entityList) {
			save(entity);
		}
	}
	
}
