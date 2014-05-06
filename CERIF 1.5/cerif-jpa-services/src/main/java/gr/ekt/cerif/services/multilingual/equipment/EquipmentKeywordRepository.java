/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;

/**
 * @author bonisv
 *
 */
public interface EquipmentKeywordRepository {

	public void delete(EquipmentKeyword entity); 
	
	public void delete(Iterable<EquipmentKeyword> entities); 

	public Iterable<EquipmentKeyword> save(Iterable<EquipmentKeyword> entities); 
	
	public EquipmentKeyword save(EquipmentKeyword entity);
	
	List<EquipmentKeyword> findByEquipment(Equipment equipment);
}
