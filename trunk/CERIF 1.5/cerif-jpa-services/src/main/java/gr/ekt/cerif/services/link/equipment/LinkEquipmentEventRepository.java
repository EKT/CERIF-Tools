package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.link.Equipment_Event;

/**
 * A repository for links between equipments and events.
 * 
 */
public interface LinkEquipmentEventRepository {

	public void delete(Equipment_Event entity); 
	
	public void delete(Iterable<Equipment_Event> entities); 

	public Iterable<Equipment_Event> save(Iterable<Equipment_Event> entities); 
	
	public Equipment_Event save(Equipment_Event entity);
	
}
