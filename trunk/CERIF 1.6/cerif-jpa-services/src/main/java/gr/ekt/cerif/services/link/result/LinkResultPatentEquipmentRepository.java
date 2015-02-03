package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.result.ResultPatent;

/**
 * A repository for links between resultPatents and equipments.
 * 
 */
public interface LinkResultPatentEquipmentRepository {

	public void delete(ResultPatent_Equipment entity); 
	
	public void delete(Iterable<ResultPatent_Equipment> entities); 

	public Iterable<ResultPatent_Equipment> save(Iterable<ResultPatent_Equipment> entities); 
	
	public ResultPatent_Equipment save(ResultPatent_Equipment entity);
	
	List<ResultPatent_Equipment> findByEquipment(Equipment equipment);
	
	List<ResultPatent_Equipment> findByResultPatent(ResultPatent resultPatent);
	
}
