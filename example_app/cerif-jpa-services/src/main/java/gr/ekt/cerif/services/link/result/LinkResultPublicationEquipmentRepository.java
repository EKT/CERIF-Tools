package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;

/**
 * A repository for links between resultPublications and equipments.
 * 
 */
public interface LinkResultPublicationEquipmentRepository {

	public void delete(ResultPublication_Equipment entity); 
	
	public void delete(Iterable<ResultPublication_Equipment> entities); 

	public Iterable<ResultPublication_Equipment> save(Iterable<ResultPublication_Equipment> entities); 
	
	public ResultPublication_Equipment save(ResultPublication_Equipment entity);
	
}
