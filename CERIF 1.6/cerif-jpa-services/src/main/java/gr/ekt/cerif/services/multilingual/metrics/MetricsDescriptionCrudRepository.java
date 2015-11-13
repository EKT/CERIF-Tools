/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MetricsDescriptionCrudRepository extends CrudRepository<MetricsDescription, Long> {
	
	List<MetricsDescription> findByMetrics(Metrics metrics);

}
