package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;

/**
 * A repository for links between resultPatents.
 * 
 */
public interface LinkResultPatentResultPatentRepository {

	public void delete(ResultPatent_ResultPatent entity); 
	
	public void delete(Iterable<ResultPatent_ResultPatent> entities); 

	public Iterable<ResultPatent_ResultPatent> save(Iterable<ResultPatent_ResultPatent> entities); 
	
	public ResultPatent_ResultPatent save(ResultPatent_ResultPatent entity);
	
}
