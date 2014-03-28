/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentName;

/**
 * @author bonisv
 *
 */
public interface EquipmentNameRepository {

	public void delete(EquipmentName entity); 
	
	public void delete(Iterable<EquipmentName> entities); 

	public Iterable<EquipmentName> save(Iterable<EquipmentName> entities); 
	
	public EquipmentName save(EquipmentName entity);
	
	List<EquipmentName> findByEquipment(Equipment equipment);
}
