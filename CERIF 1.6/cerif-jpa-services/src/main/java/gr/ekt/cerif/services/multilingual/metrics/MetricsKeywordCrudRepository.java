/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MetricsKeywordCrudRepository extends CrudRepository<MetricsKeyword, Long> {
	
	List<MetricsKeyword> findByMetrics(Metrics metrics);

}
