/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import java.util.List;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;

/**
 * @author bonisv
 *
 */
public interface MetricsKeywordRepository {
	
	public void delete(MetricsKeyword entity); 
	
	public void delete(Iterable<MetricsKeyword> entities); 

	public Iterable<MetricsKeyword> save(Iterable<MetricsKeyword> entities); 
	
	public MetricsKeyword save(MetricsKeyword entity);
	
	List<MetricsKeyword> findByMetrics(Metrics metrics);

}
