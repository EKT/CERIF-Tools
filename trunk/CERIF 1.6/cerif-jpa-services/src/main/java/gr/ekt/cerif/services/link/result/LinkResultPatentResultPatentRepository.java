package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

/**
 * A repository for links between resultPatents.
 * 
 */
public interface LinkResultPatentResultPatentRepository {

	public void delete(ResultPatent_ResultPatent entity); 
	
	public void delete(Iterable<ResultPatent_ResultPatent> entities); 

	public Iterable<ResultPatent_ResultPatent> save(Iterable<ResultPatent_ResultPatent> entities); 
	
	public ResultPatent_ResultPatent save(ResultPatent_ResultPatent entity);
	
	List<ResultPatent_ResultPatent> findByResultPatent1(ResultPatent resultPatent);
	
	List<ResultPatent_ResultPatent> findByResultPatent2(ResultPatent resultPatent);
	
}
