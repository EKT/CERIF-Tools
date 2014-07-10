package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Equipment;

/**
 * A repository for links between equipments and equipments.
 * 
 */
public interface LinkEquipmentEquipmentRepository {

	public void delete(Equipment_Equipment entity); 
	
	public void delete(Iterable<Equipment_Equipment> entities); 

	public Iterable<Equipment_Equipment> save(Iterable<Equipment_Equipment> entities); 
	
	public Equipment_Equipment save(Equipment_Equipment entity);
	
	List<Equipment_Equipment> findByEquipment1(Equipment equipment);
	
	List<Equipment_Equipment> findByEquipment2(Equipment equipment);
	
}
