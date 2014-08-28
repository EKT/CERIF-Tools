/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MetricsKeywordCrudRepository extends CrudRepository<MetricsKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MetricsKeyword> findByMetrics(Metrics metrics);

}
