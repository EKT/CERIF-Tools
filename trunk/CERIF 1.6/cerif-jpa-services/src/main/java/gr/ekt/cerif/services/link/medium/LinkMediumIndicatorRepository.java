package gr.ekt.cerif.services.link.medium;

import java.util.List;

import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between mediums and indicators.
 * 
 */
public interface LinkMediumIndicatorRepository {

	public void delete(Medium_Indicator entity); 
	
	public void delete(Iterable<Medium_Indicator> entities); 

	public Iterable<Medium_Indicator> save(Iterable<Medium_Indicator> entities); 
	
	public Medium_Indicator save(Medium_Indicator entity);
	
	List<Medium_Indicator> findByIndicator(Indicator indicator);
	
	List<Medium_Indicator> findByMedium(Medium medium);
	
}
