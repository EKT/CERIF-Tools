package gr.ekt.cerif.services.link.measurement;

import java.util.List;

import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between measurements.
 * 
 */
public interface LinkMeasurementMeasurementRepository {

	public void delete(Measurement_Measurement entity); 
	
	public void delete(Iterable<Measurement_Measurement> entities); 

	public Iterable<Measurement_Measurement> save(Iterable<Measurement_Measurement> entities); 
	
	public Measurement_Measurement save(Measurement_Measurement entity);
	
	List<Measurement_Measurement> findByMeasurement1(Measurement measurement);
	
	List<Measurement_Measurement> findByMeasurement2(Measurement measurement);
	
}
