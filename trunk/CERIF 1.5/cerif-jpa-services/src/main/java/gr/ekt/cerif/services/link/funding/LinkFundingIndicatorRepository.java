package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Indicator;

/**
 * A repository for links between facilities and indicators.
 * 
 */
public interface LinkFundingIndicatorRepository {

	public void delete(Funding_Indicator entity); 
	
	public void delete(Iterable<Funding_Indicator> entities); 

	public Iterable<Funding_Indicator> save(Iterable<Funding_Indicator> entities); 
	
	public Funding_Indicator save(Funding_Indicator entity);
	
}
