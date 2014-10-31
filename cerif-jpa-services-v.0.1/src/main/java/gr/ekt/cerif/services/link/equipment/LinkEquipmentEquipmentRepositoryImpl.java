package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Equipment;

@Component
public class LinkEquipmentEquipmentRepositoryImpl implements
		LinkEquipmentEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentEquipmentCrudRepository linkEquipmentEquipmentCrudRepository;

	@Override
	public void delete(Equipment_Equipment entity) {
		linkEquipmentEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Equipment> entities) {
		linkEquipmentEquipmentCrudRepository.save(entities);
	}

	@Override
	public Iterable<Equipment_Equipment> save(
			Iterable<Equipment_Equipment> entities) {
		return linkEquipmentEquipmentCrudRepository.save(entities);
	}

	@Override
	public Equipment_Equipment save(Equipment_Equipment entity) {
		return linkEquipmentEquipmentCrudRepository.save(entity);
	}

	@Override
	public List<Equipment_Equipment> findByEquipment1(Equipment equipment) {
		return linkEquipmentEquipmentCrudRepository.findByEquipment1(equipment);
	}

	@Override
	public List<Equipment_Equipment> findByEquipment2(Equipment equipment) {
		return linkEquipmentEquipmentCrudRepository.findByEquipment2(equipment);
	}

}
