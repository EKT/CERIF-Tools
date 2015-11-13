package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentClassCrudRepository extends CrudRepository<Equipment_Class, Long> {
	
	List<Equipment_Class> findByEquipment(Equipment equipment);
	
	List<Equipment_Class> findBytheClass(Class theClass);

}
