package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for links between resultPublications and resultPatents.
 * 
 */
public interface LinkResultPublicationResultPatentRepository {

	public void delete(ResultPublication_ResultPatent entity); 
	
	public void delete(Iterable<ResultPublication_ResultPatent> entities); 

	public Iterable<ResultPublication_ResultPatent> save(Iterable<ResultPublication_ResultPatent> entities); 
	
	public ResultPublication_ResultPatent save(ResultPublication_ResultPatent entity);
	
	List<ResultPublication_ResultPatent> findByResultPatent(ResultPatent resultPatent);
	
	List<ResultPublication_ResultPatent> findByResultPublication(ResultPublication resultPublication);
	
}
