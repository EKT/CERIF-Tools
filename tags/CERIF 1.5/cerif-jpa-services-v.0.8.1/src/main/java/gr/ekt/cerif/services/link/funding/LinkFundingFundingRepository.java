package gr.ekt.cerif.services.link.funding;

import java.util.List;

import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between fundings.
 * 
 */
public interface LinkFundingFundingRepository {

	public void delete(Funding_Funding entity); 
	
	public void delete(Iterable<Funding_Funding> entities); 

	public Iterable<Funding_Funding> save(Iterable<Funding_Funding> entities); 
	
	public Funding_Funding save(Funding_Funding entity);
	
	List<Funding_Funding> findByFunding1(Funding funding);
	
	List<Funding_Funding> findByFunding2(Funding funding);
	
	Funding_Funding findByFunding1AndFunding2(Funding funding1, Funding funding2);
	
}
