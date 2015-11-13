/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface EquipmentNameCrudRepository extends CrudRepository<EquipmentName, Long>  {
	
	List<EquipmentName> findByEquipment(Equipment equipment);

}
