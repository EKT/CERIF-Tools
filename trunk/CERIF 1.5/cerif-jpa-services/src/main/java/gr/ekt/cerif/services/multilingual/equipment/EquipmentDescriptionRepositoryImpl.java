/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;


/**
 * @author bonisv
 *
 */
@Component
public class EquipmentDescriptionRepositoryImpl implements EquipmentDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(EquipmentDescriptionRepositoryImpl.class);
	
	@Autowired
	private EquipmentDescriptionCrudRepository equipmentDescriptionCrudRepository;

	@Override
	public void delete(EquipmentDescription entity) {
		equipmentDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<EquipmentDescription> entities) {
		equipmentDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<EquipmentDescription> save(Iterable<EquipmentDescription> entities) {
		return equipmentDescriptionCrudRepository.save(entities);
	}

	@Override
	public EquipmentDescription save(EquipmentDescription entity) {
		return equipmentDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<EquipmentDescription> findByEquipment(Equipment equipment) {
		return equipmentDescriptionCrudRepository.findByEquipment(equipment);
	}

}
