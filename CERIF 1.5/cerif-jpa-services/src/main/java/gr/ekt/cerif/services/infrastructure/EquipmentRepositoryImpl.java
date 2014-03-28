package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;

@Component
public class EquipmentRepositoryImpl implements EquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(EquipmentRepositoryImpl.class);
	
	@Autowired
	private EquipmentCrudRepository equipmentCrudRepository;

	@Override
	public void delete(Equipment entity) {
		equipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment> entities) {
		equipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment> save(Iterable<Equipment> entities) {
		return equipmentCrudRepository.save(entities);
	}

	@Override
	public Equipment save(Equipment entity) {
		return equipmentCrudRepository.save(entity);
	}

	@Override
	public List<Equipment> findAll() {
		return equipmentCrudRepository.findAll();
	}

	@Override
	public Page<Equipment> findAll(Pageable page) {
		return equipmentCrudRepository.findAll(page);
	}

}
