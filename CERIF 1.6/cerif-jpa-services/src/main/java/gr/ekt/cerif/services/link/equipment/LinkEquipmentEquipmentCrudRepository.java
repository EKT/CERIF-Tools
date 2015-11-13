package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Equipment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentEquipmentCrudRepository extends CrudRepository<Equipment_Equipment, Long> {
	
	List<Equipment_Equipment> findByEquipment1(Equipment equipment);
	
	List<Equipment_Equipment> findByEquipment2(Equipment equipment);

}
