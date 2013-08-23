package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.link.Equipment_Funding;

/**
 * A repository for links between equipments and fundings.
 * 
 */
public interface LinkEquipmentFundingRepository {

	public void delete(Equipment_Funding entity); 
	
	public void delete(Iterable<Equipment_Funding> entities); 

	public Iterable<Equipment_Funding> save(Iterable<Equipment_Funding> entities); 
	
	public Equipment_Funding save(Equipment_Funding entity);
	
}
