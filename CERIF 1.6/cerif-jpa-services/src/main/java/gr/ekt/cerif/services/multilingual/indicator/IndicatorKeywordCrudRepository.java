/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface IndicatorKeywordCrudRepository extends CrudRepository<IndicatorKeyword, Long> {
	
	List<IndicatorKeyword> findByIndicator(Indicator indicator);

}
