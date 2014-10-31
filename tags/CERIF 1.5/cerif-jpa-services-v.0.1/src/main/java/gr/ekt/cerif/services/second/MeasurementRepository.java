/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Measurement;

/**
 * @author bonisv
 *
 */
public interface MeasurementRepository {

	void delete(Measurement entity); 
	
	void delete(Iterable<Measurement> entities); 

	Iterable<Measurement> save(Iterable<Measurement> entities); 
	
	Measurement save(Measurement entity);
	
	List<Measurement> findAll();
	
	Page<Measurement> findAll(Pageable page);
	
	Measurement findByUuid(String uuid);

	Measurement findById(Long id);
	
	List<Measurement> findByUri(String uri);
	
}
