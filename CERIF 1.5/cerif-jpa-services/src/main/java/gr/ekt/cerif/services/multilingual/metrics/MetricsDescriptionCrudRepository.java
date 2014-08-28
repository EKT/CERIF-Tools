/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MetricsDescriptionCrudRepository extends CrudRepository<MetricsDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MetricsDescription> findByMetrics(Metrics metrics);

}
