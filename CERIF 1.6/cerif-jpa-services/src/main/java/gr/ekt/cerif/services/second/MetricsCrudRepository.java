/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Metrics;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for metrics.
 * 
 */
public interface MetricsCrudRepository extends CrudRepository<Metrics, Long> {
	
	public List<Metrics> findAll();
	
	public Page<Metrics> findAll(Pageable page);

	public Metrics findById(Long id);

	public List<Metrics> findByUri(String uri);

	public Metrics findByUuid(String uuid);

}
