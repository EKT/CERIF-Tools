/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MetricsNameCrudRepository extends CrudRepository<MetricsName, Long> {
	
	List<MetricsName> findByMetrics(Metrics metrics);

}
