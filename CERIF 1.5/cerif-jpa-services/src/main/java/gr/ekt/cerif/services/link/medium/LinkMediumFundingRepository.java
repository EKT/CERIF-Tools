package gr.ekt.cerif.services.link.medium;

import java.util.List;

import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between mediums and fundings.
 * 
 */
public interface LinkMediumFundingRepository {

	public void delete(Medium_Funding entity); 
	
	public void delete(Iterable<Medium_Funding> entities); 

	public Iterable<Medium_Funding> save(Iterable<Medium_Funding> entities); 
	
	public Medium_Funding save(Medium_Funding entity);
	
	List<Medium_Funding> findByFunding(Funding funding);
	
	List<Medium_Funding> findByMedium(Medium medium);
	
}
