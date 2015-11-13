package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentEventCrudRepository extends CrudRepository<Equipment_Event, Long> {
	
	List<Equipment_Event> findByEvent(Event event);
	
	List<Equipment_Event> findByEquipment(Equipment equipment);

}
