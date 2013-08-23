/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

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
}
