package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Equipment_Service;

/**
 * A repository for links between equipments and services.
 * 
 */
public interface LinkEquipmentServiceRepository {

	public void delete(Equipment_Service entity); 
	
	public void delete(Iterable<Equipment_Service> entities); 

	public Iterable<Equipment_Service> save(Iterable<Equipment_Service> entities); 
	
	public Equipment_Service save(Equipment_Service entity);
	
	List<Equipment_Service> findByService(Service service);
	
	List<Equipment_Service> findByEquipment(Equipment equipment);
	
}
