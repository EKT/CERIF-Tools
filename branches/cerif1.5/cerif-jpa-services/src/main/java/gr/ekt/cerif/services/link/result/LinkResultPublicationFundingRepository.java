package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;

/**
 * A repository for links between resultPublications and fundings.
 * 
 */
public interface LinkResultPublicationFundingRepository {

	public void delete(ResultPublication_Funding entity); 
	
	public void delete(Iterable<ResultPublication_Funding> entities); 

	public Iterable<ResultPublication_Funding> save(Iterable<ResultPublication_Funding> entities); 
	
	public ResultPublication_Funding save(ResultPublication_Funding entity);
	
}
