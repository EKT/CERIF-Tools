package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Measurement;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

public interface LinkGeographicBoundingBoxMeasurementRepository {

	void delete(GeographicBoundingBox_Measurement entity); 
	
	void delete(Iterable<GeographicBoundingBox_Measurement> entities); 

	Iterable<GeographicBoundingBox_Measurement> save(Iterable<GeographicBoundingBox_Measurement> entities); 
	
	GeographicBoundingBox_Measurement save(GeographicBoundingBox_Measurement entity);
	
	List<GeographicBoundingBox_Measurement> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<GeographicBoundingBox_Measurement> findByMeasurement(Measurement measurement);
	
}
