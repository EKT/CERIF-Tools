package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between resultPublications and fundings.
 * 
 */
public interface LinkResultPublicationFundingRepository {

	public void delete(ResultPublication_Funding entity); 
	
	public void delete(Iterable<ResultPublication_Funding> entities); 

	public Iterable<ResultPublication_Funding> save(Iterable<ResultPublication_Funding> entities); 
	
	public ResultPublication_Funding save(ResultPublication_Funding entity);
	
	List<ResultPublication_Funding> findByFunding(Funding funding);
	
	List<ResultPublication_Funding> findByResultPublication(ResultPublication resultPublication);
	
}
