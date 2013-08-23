package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;

/**
 * A repository for links between resultPatents and mediums.
 * 
 */
public interface LinkResultPatentMediumRepository {

	public void delete(ResultPatent_Medium entity); 
	
	public void delete(Iterable<ResultPatent_Medium> entities); 

	public Iterable<ResultPatent_Medium> save(Iterable<ResultPatent_Medium> entities); 
	
	public ResultPatent_Medium save(ResultPatent_Medium entity);
	
}
