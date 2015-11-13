package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationEquipmentCrudRepository extends CrudRepository<ResultPublication_Equipment, Long> {
	
	List<ResultPublication_Equipment> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Equipment> findByEquipment(Equipment equipment);

}
