package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;

/**
 * A repository for links between resultProducts and equipments.
 * 
 */
public interface LinkResultProductEquipmentRepository {

	public void delete(ResultProduct_Equipment entity); 
	
	public void delete(Iterable<ResultProduct_Equipment> entities); 

	public Iterable<ResultProduct_Equipment> save(Iterable<ResultProduct_Equipment> entities); 
	
	public ResultProduct_Equipment save(ResultProduct_Equipment entity);
	
}
