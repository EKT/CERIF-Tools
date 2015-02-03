/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface IndicatorKeywordCrudRepository extends CrudRepository<IndicatorKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<IndicatorKeyword> findByIndicator(Indicator indicator);

}
