/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface IndicatorNameCrudRepository extends CrudRepository<IndicatorName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<IndicatorName> findByIndicator(Indicator indicator);

}
