package gr.ekt.cerif.services.link.indicator;

import gr.ekt.cerif.entities.link.Indicator_Indicator;

/**
 * A repository for links between indicators.
 * 
 */
public interface LinkIndicatorIndicatorRepository {

	public void delete(Indicator_Indicator entity); 
	
	public void delete(Iterable<Indicator_Indicator> entities); 

	public Iterable<Indicator_Indicator> save(Iterable<Indicator_Indicator> entities); 
	
	public Indicator_Indicator save(Indicator_Indicator entity);
	
}
