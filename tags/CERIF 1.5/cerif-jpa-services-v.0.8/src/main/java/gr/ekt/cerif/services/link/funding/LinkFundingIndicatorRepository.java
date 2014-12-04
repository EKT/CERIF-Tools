package gr.ekt.cerif.services.link.funding;

import java.util.List;

import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;

/**
 * A repository for links between facilities and indicators.
 * 
 */
public interface LinkFundingIndicatorRepository {

	public void delete(Funding_Indicator entity); 
	
	public void delete(Iterable<Funding_Indicator> entities); 

	public Iterable<Funding_Indicator> save(Iterable<Funding_Indicator> entities); 
	
	public Funding_Indicator save(Funding_Indicator entity);
	
	List<Funding_Indicator> findByFunding(Funding funding);
	
	List<Funding_Indicator> findByIndicator(Indicator indicator);
	
}
