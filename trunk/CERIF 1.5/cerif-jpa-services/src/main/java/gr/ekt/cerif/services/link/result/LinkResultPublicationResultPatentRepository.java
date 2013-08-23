package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;

/**
 * A repository for links between resultPublications and resultPatents.
 * 
 */
public interface LinkResultPublicationResultPatentRepository {

	public void delete(ResultPublication_ResultPatent entity); 
	
	public void delete(Iterable<ResultPublication_ResultPatent> entities); 

	public Iterable<ResultPublication_ResultPatent> save(Iterable<ResultPublication_ResultPatent> entities); 
	
	public ResultPublication_ResultPatent save(ResultPublication_ResultPatent entity);
	
}
