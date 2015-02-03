/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import java.util.List;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;

/**
 * @author bonisv
 *
 */
public interface MeasurementDescriptionRepository {

	public void delete(MeasurementDescription entity); 
	
	public void delete(Iterable<MeasurementDescription> entities); 

	public Iterable<MeasurementDescription> save(Iterable<MeasurementDescription> entities); 
	
	public MeasurementDescription save(MeasurementDescription entity);
	
	List<MeasurementDescription> findByMeasurement(Measurement measurement);
}
