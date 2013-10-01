package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.link.Equipment_Measurement;

/**
 * A repository for links between equipments and measurements.
 * 
 */
public interface LinkEquipmentMeasurementRepository {

	public void delete(Equipment_Measurement entity); 
	
	public void delete(Iterable<Equipment_Measurement> entities); 

	public Iterable<Equipment_Measurement> save(Iterable<Equipment_Measurement> entities); 
	
	public Equipment_Measurement save(Equipment_Measurement entity);
	
}
