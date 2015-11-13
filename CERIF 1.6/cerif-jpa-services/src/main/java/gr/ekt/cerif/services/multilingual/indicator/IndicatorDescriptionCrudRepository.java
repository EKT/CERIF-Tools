/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface IndicatorDescriptionCrudRepository extends CrudRepository<IndicatorDescription, Long> {
	
	List<IndicatorDescription> findByIndicator(Indicator indicator);

}
