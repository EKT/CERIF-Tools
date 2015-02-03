/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import java.util.List;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;

/**
 * @author bonisv
 *
 */
public interface MeasurementKeywordRepository {
	
	public void delete(MeasurementKeyword entity); 
	
	public void delete(Iterable<MeasurementKeyword> entities); 

	public Iterable<MeasurementKeyword> save(Iterable<MeasurementKeyword> entities); 
	
	public MeasurementKeyword save(MeasurementKeyword entity);
	
	List<MeasurementKeyword> findByMeasurement(Measurement measurement);

}
