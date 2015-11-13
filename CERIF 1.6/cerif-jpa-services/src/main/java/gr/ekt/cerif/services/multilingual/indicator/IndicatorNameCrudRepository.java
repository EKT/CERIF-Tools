/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface IndicatorNameCrudRepository extends CrudRepository<IndicatorName, Long> {
	
	List<IndicatorName> findByIndicator(Indicator indicator);

}
