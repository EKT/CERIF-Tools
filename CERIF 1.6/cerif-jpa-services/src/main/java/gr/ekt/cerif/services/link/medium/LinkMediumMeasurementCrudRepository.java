package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMediumMeasurementCrudRepository extends CrudRepository<Medium_Measurement, Long> {
	
	List<Medium_Measurement> findByMeasurement(Measurement measurement);
	
	List<Medium_Measurement> findByMedium(Medium medium);

}
