/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Indicator;

/**
 * @author bonisv
 *
 */
public interface IndicatorRepository {

	public void delete(Indicator entity); 
	
	public void delete(Iterable<Indicator> entities); 

	public Iterable<Indicator> save(Iterable<Indicator> entities); 
	
	public Indicator save(Indicator entity);
	
	List<Indicator> findAll();
	
	Page<Indicator> findAll(Pageable page);
	
	Indicator findByUuid(String uuid);
	
	Indicator findById(Long id);
}
