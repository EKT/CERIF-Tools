/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for indicators.
 * 
 */
public interface IndicatorCrudRepository extends CrudRepository<Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Page<Indicator> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Indicator findByUuid(String uuid);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Indicator findById(Long id);

}
