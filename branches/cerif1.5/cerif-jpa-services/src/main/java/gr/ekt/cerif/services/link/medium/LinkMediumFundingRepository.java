package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Funding;

/**
 * A repository for links between mediums and fundings.
 * 
 */
public interface LinkMediumFundingRepository {

	public void delete(Medium_Funding entity); 
	
	public void delete(Iterable<Medium_Funding> entities); 

	public Iterable<Medium_Funding> save(Iterable<Medium_Funding> entities); 
	
	public Medium_Funding save(Medium_Funding entity);
	
}
