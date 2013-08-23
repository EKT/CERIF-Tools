/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import gr.ekt.cerif.features.multilingual.IndicatorName;

/**
 * @author bonisv
 *
 */
public interface IndicatorNameRepository {
	
	public void delete(IndicatorName entity); 
	
	public void delete(Iterable<IndicatorName> entities); 

	public Iterable<IndicatorName> save(Iterable<IndicatorName> entities); 
	
	public IndicatorName save(IndicatorName entity);

}
