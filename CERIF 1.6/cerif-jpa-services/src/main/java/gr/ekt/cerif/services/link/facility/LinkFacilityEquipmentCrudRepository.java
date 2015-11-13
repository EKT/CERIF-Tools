package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Equipment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityEquipmentCrudRepository extends CrudRepository<Facility_Equipment, Long> {
	
	List<Facility_Equipment> findByFacility(Facility facility);
	
	List<Facility_Equipment> findByEquipment(Equipment equipment);

}
