/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface IndicatorDescriptionCrudRepository extends CrudRepository<IndicatorDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<IndicatorDescription> findByIndicator(Indicator indicator);

}
