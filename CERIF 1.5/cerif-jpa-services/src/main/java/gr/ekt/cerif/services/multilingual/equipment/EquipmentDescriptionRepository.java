/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;

/**
 * @author bonisv
 *
 */
public interface EquipmentDescriptionRepository {
	
	public void delete(EquipmentDescription entity); 
	
	public void delete(Iterable<EquipmentDescription> entities); 

	public Iterable<EquipmentDescription> save(Iterable<EquipmentDescription> entities); 
	
	public EquipmentDescription save(EquipmentDescription entity);
	
	List<EquipmentDescription> findByEquipment(Equipment equipment);

}
