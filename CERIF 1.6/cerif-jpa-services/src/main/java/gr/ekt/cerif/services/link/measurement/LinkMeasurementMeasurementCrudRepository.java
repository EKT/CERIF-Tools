package gr.ekt.cerif.services.link.measurement;

import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMeasurementMeasurementCrudRepository extends CrudRepository<Measurement_Measurement, Long> {
	
	List<Measurement_Measurement> findByMeasurement1(Measurement measurement);
	
	List<Measurement_Measurement> findByMeasurement2(Measurement measurement);

}
