package gr.ekt.cerif.services.link.indicator;

import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkIndicatorMeasurementCrudRepository extends CrudRepository<Indicator_Measurement, Long> {
	
	List<Indicator_Measurement> findByMeasurement(Measurement measurement);
	
	List<Indicator_Measurement> findByIndicator(Indicator indicator);

}
