/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Metrics;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for metrics.
 * 
 */
public interface MetricsRepository extends CrudRepository<Metrics, String> {

}
