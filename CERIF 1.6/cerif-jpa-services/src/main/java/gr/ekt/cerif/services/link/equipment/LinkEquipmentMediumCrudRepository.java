package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentMediumCrudRepository extends CrudRepository<Equipment_Medium, Long> {
	
	List<Equipment_Medium> findByMedium(Medium medium);
	
	List<Equipment_Medium> findByEquipment(Equipment equipment);

}
