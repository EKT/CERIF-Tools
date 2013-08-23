/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.EquipmentKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class EquipmentKeywordRepositoryImpl implements EquipmentKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(EquipmentKeywordRepositoryImpl.class);
	
	@Autowired
	private EquipmentKeywordCrudRepository equipmentKeywordCrudRepository;

	@Override
	public void delete(EquipmentKeyword entity) {
		equipmentKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<EquipmentKeyword> entities) {
		equipmentKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<EquipmentKeyword> save(Iterable<EquipmentKeyword> entities) {
		return equipmentKeywordCrudRepository.save(entities);
	}

	@Override
	public EquipmentKeyword save(EquipmentKeyword entity) {
		return equipmentKeywordCrudRepository.save(entity);
	}

}
