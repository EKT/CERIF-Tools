package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Funding;

/**
 * A repository for links between fundings.
 * 
 */
public interface LinkFundingFundingRepository {

	public void delete(Funding_Funding entity); 
	
	public void delete(Iterable<Funding_Funding> entities); 

	public Iterable<Funding_Funding> save(Iterable<Funding_Funding> entities); 
	
	public Funding_Funding save(Funding_Funding entity);
	
}
