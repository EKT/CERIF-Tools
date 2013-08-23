package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Equipment;

/**
 * A repository for links between facilities and equipments.
 * 
 */
public interface LinkFacilityEquipmentRepository {

	public void delete(Facility_Equipment entity); 
	
	public void delete(Iterable<Facility_Equipment> entities); 

	public Iterable<Facility_Equipment> save(Iterable<Facility_Equipment> entities); 
	
	public Facility_Equipment save(Facility_Equipment entity);
	
}
