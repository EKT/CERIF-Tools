package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentIndicatorCrudRepository extends CrudRepository<Equipment_Indicator, Long> {
	
	List<Equipment_Indicator> findByIndicator(Indicator indicator);
	
	List<Equipment_Indicator> findByEquipment(Equipment equipment);

}
