package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between indicators and measurements.
 * 
 */
public interface LinkIndicatorMeasurementRepository {

	public void delete(Indicator_Measurement entity); 
	
	public void delete(Iterable<Indicator_Measurement> entities); 

	public Iterable<Indicator_Measurement> save(Iterable<Indicator_Measurement> entities); 
	
	public Indicator_Measurement save(Indicator_Measurement entity);
	
	List<Indicator_Measurement> findByMeasurement(Measurement measurement);
	
	List<Indicator_Measurement> findByIndicator(Indicator indicator);
	
}
