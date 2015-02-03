package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between equipments and fundings.
 * 
 */
public interface LinkEquipmentFundingRepository {

	public void delete(Equipment_Funding entity); 
	
	public void delete(Iterable<Equipment_Funding> entities); 

	public Iterable<Equipment_Funding> save(Iterable<Equipment_Funding> entities); 
	
	public Equipment_Funding save(Equipment_Funding entity);
	
	List<Equipment_Funding> findByFunding(Funding funding);
	
	List<Equipment_Funding> findByEquipment(Equipment equipment);
	
}
