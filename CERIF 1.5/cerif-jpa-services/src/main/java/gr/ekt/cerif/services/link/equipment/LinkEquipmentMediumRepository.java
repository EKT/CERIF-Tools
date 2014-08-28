package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between equipments and mediums.
 * 
 */
public interface LinkEquipmentMediumRepository {

	public void delete(Equipment_Medium entity); 
	
	public void delete(Iterable<Equipment_Medium> entities); 

	public Iterable<Equipment_Medium> save(Iterable<Equipment_Medium> entities); 
	
	public Equipment_Medium save(Equipment_Medium entity);
	
	List<Equipment_Medium> findByMedium(Medium medium);
	
	List<Equipment_Medium> findByEquipment(Equipment equipment);
	
}
