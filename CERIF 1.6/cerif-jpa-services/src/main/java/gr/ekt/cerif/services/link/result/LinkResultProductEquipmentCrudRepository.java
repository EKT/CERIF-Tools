package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductEquipmentCrudRepository extends CrudRepository<ResultProduct_Equipment, Long> {
	
	List<ResultProduct_Equipment> findByEquipment(Equipment equipment);
	
	List<ResultProduct_Equipment> findByResultProduct(ResultProduct resultProduct);

}
