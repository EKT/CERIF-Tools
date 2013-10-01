/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import gr.ekt.cerif.features.multilingual.MetricsDescription;

/**
 * @author bonisv
 *
 */
public interface MetricsDescriptionRepository {
	
	public void delete(MetricsDescription entity); 
	
	public void delete(Iterable<MetricsDescription> entities); 

	public Iterable<MetricsDescription> save(Iterable<MetricsDescription> entities); 
	
	public MetricsDescription save(MetricsDescription entity);

}
