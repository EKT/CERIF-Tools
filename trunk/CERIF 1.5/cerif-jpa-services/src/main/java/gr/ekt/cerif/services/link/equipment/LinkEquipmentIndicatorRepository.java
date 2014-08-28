package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

/**
 * A repository for links between equipments and indicators.
 * 
 */
public interface LinkEquipmentIndicatorRepository {

	public void delete(Equipment_Indicator entity); 
	
	public void delete(Iterable<Equipment_Indicator> entities); 

	public Iterable<Equipment_Indicator> save(Iterable<Equipment_Indicator> entities); 
	
	public Equipment_Indicator save(Equipment_Indicator entity);
	
	List<Equipment_Indicator> findByIndicator(Indicator indicator);
	
	List<Equipment_Indicator> findByEquipment(Equipment equipment);
	
}
