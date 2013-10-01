package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.link.Equipment_Indicator;

/**
 * A repository for links between equipments and indicators.
 * 
 */
public interface LinkEquipmentIndicatorRepository {

	public void delete(Equipment_Indicator entity); 
	
	public void delete(Iterable<Equipment_Indicator> entities); 

	public Iterable<Equipment_Indicator> save(Iterable<Equipment_Indicator> entities); 
	
	public Equipment_Indicator save(Equipment_Indicator entity);
	
}
