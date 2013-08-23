package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Indicator;

/**
 * A repository for links between mediums and indicators.
 * 
 */
public interface LinkMediumIndicatorRepository {

	public void delete(Medium_Indicator entity); 
	
	public void delete(Iterable<Medium_Indicator> entities); 

	public Iterable<Medium_Indicator> save(Iterable<Medium_Indicator> entities); 
	
	public Medium_Indicator save(Medium_Indicator entity);
	
}
