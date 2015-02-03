package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between resultProducts and fundings.
 * 
 */
public interface LinkResultProductFundingRepository {

	public void delete(ResultProduct_Funding entity); 
	
	public void delete(Iterable<ResultProduct_Funding> entities); 

	public Iterable<ResultProduct_Funding> save(Iterable<ResultProduct_Funding> entities); 
	
	public ResultProduct_Funding save(ResultProduct_Funding entity);
	
	List<ResultProduct_Funding> findByFunding(Funding funding);
	
	List<ResultProduct_Funding> findByResultProduct(ResultProduct resultProduct);
	
}
