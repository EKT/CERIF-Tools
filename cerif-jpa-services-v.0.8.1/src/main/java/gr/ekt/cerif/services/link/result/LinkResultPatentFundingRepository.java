package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between resultPatents and fundings.
 * 
 */
public interface LinkResultPatentFundingRepository {

	public void delete(ResultPatent_Funding entity); 
	
	public void delete(Iterable<ResultPatent_Funding> entities); 

	public Iterable<ResultPatent_Funding> save(Iterable<ResultPatent_Funding> entities); 
	
	public ResultPatent_Funding save(ResultPatent_Funding entity);
	
	List<ResultPatent_Funding> findByFunding(Funding funding);
	
	List<ResultPatent_Funding> findByResultPatent(ResultPatent resultPatent);
	
}
