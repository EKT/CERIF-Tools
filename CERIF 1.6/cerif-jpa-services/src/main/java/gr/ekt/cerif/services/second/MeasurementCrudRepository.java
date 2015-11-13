/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for measurements.
 * 
 */
public interface MeasurementCrudRepository extends CrudRepository<Measurement, String> {
	
	public List<Measurement> findAll();
	
	public Page<Measurement> findAll(Pageable page);
	
	public Measurement findByUuid(String uuid);
	
	public Measurement findById(Long id);
	
	public List<Measurement> findByUri(String uri);
}
