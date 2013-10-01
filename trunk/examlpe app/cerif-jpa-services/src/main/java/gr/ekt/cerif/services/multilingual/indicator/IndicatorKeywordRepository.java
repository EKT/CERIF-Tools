/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

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

}
