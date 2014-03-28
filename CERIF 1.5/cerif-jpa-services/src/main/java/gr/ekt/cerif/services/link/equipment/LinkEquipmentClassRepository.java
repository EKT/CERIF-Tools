package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between equipments and classes.
 * 
 */
public interface LinkEquipmentClassRepository {

	public void delete(Equipment_Class entity); 
	
	public void delete(Iterable<Equipment_Class> entities); 

	public Iterable<Equipment_Class> save(Iterable<Equipment_Class> entities); 
	
	public Equipment_Class save(Equipment_Class entity);
	
	List<Equipment_Class> findByEquipment(Equipment equipment);
	
	List<Equipment_Class> findBytheClass(Class theClass);
	
}
