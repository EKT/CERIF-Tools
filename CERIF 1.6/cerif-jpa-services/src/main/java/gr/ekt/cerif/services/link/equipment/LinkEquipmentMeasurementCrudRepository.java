package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentMeasurementCrudRepository extends CrudRepository<Equipment_Measurement, Long> {
	
	List<Equipment_Measurement> findByMeasurement(Measurement measurement);
	
	List<Equipment_Measurement> findByEquipment(Equipment equipment);

}
