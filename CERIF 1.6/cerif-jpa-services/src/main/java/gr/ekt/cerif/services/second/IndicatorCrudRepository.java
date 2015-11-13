/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for indicators.
 * 
 */
public interface IndicatorCrudRepository extends CrudRepository<Indicator, Long> {
	
	public List<Indicator> findAll();
	
	public Page<Indicator> findAll(Pageable page);
	
	public Indicator findByUuid(String uuid);
	
	public Indicator findById(Long id);
	
	public List<Indicator> findByUri(String uri);

}
