/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import java.util.List;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsName;

/**
 * @author bonisv
 *
 */
public interface MetricsNameRepository {
	
	public void delete(MetricsName entity); 
	
	public void delete(Iterable<MetricsName> entities); 

	public Iterable<MetricsName> save(Iterable<MetricsName> entities); 
	
	public MetricsName save(MetricsName entity);
	
	List<MetricsName> findByMetrics(Metrics metrics);

}
