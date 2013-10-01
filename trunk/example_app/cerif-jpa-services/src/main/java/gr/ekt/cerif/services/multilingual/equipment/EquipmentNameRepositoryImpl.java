/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.EquipmentName;


/**
 * @author bonisv
 *
 */
@Component
public class EquipmentNameRepositoryImpl implements EquipmentNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(EquipmentNameRepositoryImpl.class);
	
	@Autowired
	private EquipmentNameCrudRepository equipmentNameCrudRepository;

	@Override
	public void delete(EquipmentName entity) {
		equipmentNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<EquipmentName> entities) {
		equipmentNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<EquipmentName> save(Iterable<EquipmentName> entities) {
		return equipmentNameCrudRepository.save(entities);
	}

	@Override
	public EquipmentName save(EquipmentName entity) {
		return equipmentNameCrudRepository.save(entity);
	}

}
