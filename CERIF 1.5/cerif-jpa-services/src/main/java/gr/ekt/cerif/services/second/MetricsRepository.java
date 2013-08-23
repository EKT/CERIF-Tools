/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Metrics;

/**
 * @author bonisv
 *
 */
public interface MetricsRepository {

	public void delete(Metrics entity); 
	
	public void delete(Iterable<Metrics> entities); 

	public Iterable<Metrics> save(Iterable<Metrics> entities); 
	
	public Metrics save(Metrics entity);
}
