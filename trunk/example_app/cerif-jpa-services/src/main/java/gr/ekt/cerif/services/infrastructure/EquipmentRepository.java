package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Equipment;

public interface EquipmentRepository {
	
	public void delete(Equipment entity); 
	
	public void delete(Iterable<Equipment> entities); 

	public Iterable<Equipment> save(Iterable<Equipment> entities); 
	
	public Equipment save(Equipment entity);

}
