/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface EquipmentKeywordCrudRepository extends CrudRepository<EquipmentKeyword, Long>  {
	
	List<EquipmentKeyword> findByEquipment(Equipment equipment);

}
