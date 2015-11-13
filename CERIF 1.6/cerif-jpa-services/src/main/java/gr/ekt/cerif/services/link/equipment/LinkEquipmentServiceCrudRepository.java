package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Equipment_Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentServiceCrudRepository extends CrudRepository<Equipment_Service, Long> {
	
	List<Equipment_Service> findByService(Service service);
	
	List<Equipment_Service> findByEquipment(Equipment equipment);

}
