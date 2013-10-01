package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;

/**
 * A repository for links between resultProducts and fundings.
 * 
 */
public interface LinkResultProductFundingRepository {

	public void delete(ResultProduct_Funding entity); 
	
	public void delete(Iterable<ResultProduct_Funding> entities); 

	public Iterable<ResultProduct_Funding> save(Iterable<ResultProduct_Funding> entities); 
	
	public ResultProduct_Funding save(ResultProduct_Funding entity);
	
}
