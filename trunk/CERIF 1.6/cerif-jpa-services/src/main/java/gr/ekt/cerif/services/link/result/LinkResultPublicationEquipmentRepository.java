package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for links between resultPublications and equipments.
 * 
 */
public interface LinkResultPublicationEquipmentRepository {

	public void delete(ResultPublication_Equipment entity); 
	
	public void delete(Iterable<ResultPublication_Equipment> entities); 

	public Iterable<ResultPublication_Equipment> save(Iterable<ResultPublication_Equipment> entities); 
	
	public ResultPublication_Equipment save(ResultPublication_Equipment entity);
	
	List<ResultPublication_Equipment> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Equipment> findByEquipment(Equipment equipment);
	
}
