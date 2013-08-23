/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Indicator;

/**
 * @author bonisv
 *
 */
public interface IndicatorRepository {

	public void delete(Indicator entity); 
	
	public void delete(Iterable<Indicator> entities); 

	public Iterable<Indicator> save(Iterable<Indicator> entities); 
	
	public Indicator save(Indicator entity);
}
