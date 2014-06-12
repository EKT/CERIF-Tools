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

	public void delete(Measurement entity); 
	
	public void delete(Iterable<Measurement> entities); 

	public Iterable<Measurement> save(Iterable<Measurement> entities); 
	
	public Measurement save(Measurement entity);
	
	List<Measurement> findAll();
	
	Page<Measurement> findAll(Pageable page);
	
	Measurement findByUuid(String uuid);
	
}
