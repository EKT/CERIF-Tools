/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import java.util.List;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;

/**
 * @author bonisv
 *
 */
public interface IndicatorKeywordRepository {
	
	public void delete(IndicatorKeyword entity); 
	
	public void delete(Iterable<IndicatorKeyword> entities); 

	public Iterable<IndicatorKeyword> save(Iterable<IndicatorKeyword> entities); 
	
	public IndicatorKeyword save(IndicatorKeyword entity);
	
	List<IndicatorKeyword> findByIndicator(Indicator indicator);

}
