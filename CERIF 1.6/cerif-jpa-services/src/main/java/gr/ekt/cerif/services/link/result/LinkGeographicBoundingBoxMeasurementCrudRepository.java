package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Measurement;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkGeographicBoundingBoxMeasurementCrudRepository extends CrudRepository<GeographicBoundingBox_Measurement, Long> {
	
	List<GeographicBoundingBox_Measurement> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<GeographicBoundingBox_Measurement> findByMeasurement(Measurement measurement);

}
