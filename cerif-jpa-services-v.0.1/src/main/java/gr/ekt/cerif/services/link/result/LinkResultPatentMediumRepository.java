package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between resultPatents and mediums.
 * 
 */
public interface LinkResultPatentMediumRepository {

	public void delete(ResultPatent_Medium entity); 
	
	public void delete(Iterable<ResultPatent_Medium> entities); 

	public Iterable<ResultPatent_Medium> save(Iterable<ResultPatent_Medium> entities); 
	
	public ResultPatent_Medium save(ResultPatent_Medium entity);
	
	List<ResultPatent_Medium> findByMedium(Medium medium);
	
	List<ResultPatent_Medium> findByResultPatent(ResultPatent resultPatent);
	
}
