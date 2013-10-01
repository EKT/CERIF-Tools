/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Measurement;

/**
 * @author bonisv
 *
 */
public interface MeasurementRepository {

	public void delete(Measurement entity); 
	
	public void delete(Iterable<Measurement> entities); 

	public Iterable<Measurement> save(Iterable<Measurement> entities); 
	
	public Measurement save(Measurement entity);
	
}
