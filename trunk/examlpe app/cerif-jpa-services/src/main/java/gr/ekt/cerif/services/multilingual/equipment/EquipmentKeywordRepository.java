/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

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
}
