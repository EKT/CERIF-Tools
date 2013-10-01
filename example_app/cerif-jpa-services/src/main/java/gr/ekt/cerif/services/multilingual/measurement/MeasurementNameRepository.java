/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import gr.ekt.cerif.features.multilingual.MeasurementName;

/**
 * @author bonisv
 *
 */
public interface MeasurementNameRepository {
	
	public void delete(MeasurementName entity); 
	
	public void delete(Iterable<MeasurementName> entities); 

	public Iterable<MeasurementName> save(Iterable<MeasurementName> entities); 
	
	public MeasurementName save(MeasurementName entity);

}
