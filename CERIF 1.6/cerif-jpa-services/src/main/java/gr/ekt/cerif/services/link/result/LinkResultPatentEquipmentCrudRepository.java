package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentEquipmentCrudRepository extends CrudRepository<ResultPatent_Equipment, Long> {
	
	List<ResultPatent_Equipment> findByEquipment(Equipment equipment);
	
	List<ResultPatent_Equipment> findByResultPatent(ResultPatent resultPatent);

}
