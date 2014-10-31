/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Metrics;

/**
 * @author bonisv
 *
 */
public interface MetricsRepository {

	void delete(Metrics entity); 
	
	void delete(Iterable<Metrics> entities); 

	Iterable<Metrics> save(Iterable<Metrics> entities); 
	
	Metrics save(Metrics entity);
	
	List<Metrics> findAll();
	
	Page<Metrics> findAll(Pageable page);

	Metrics findById(Long id);

	List<Metrics> findByUri(String uri);

	Metrics findByUuid(String uuid);
}
