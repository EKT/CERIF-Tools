/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface EquipmentDescriptionCrudRepository extends CrudRepository<EquipmentDescription, Long>  {
	
	List<EquipmentDescription> findByEquipment(Equipment equipment);

}
