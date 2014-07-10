package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for links between resultPublications and resultPublications.
 * 
 */
public interface LinkResultPublicationResultPublicationRepository {

	public void delete(ResultPublication_ResultPublication entity); 
	
	public void delete(Iterable<ResultPublication_ResultPublication> entities); 

	public Iterable<ResultPublication_ResultPublication> save(Iterable<ResultPublication_ResultPublication> entities); 
	
	public ResultPublication_ResultPublication save(ResultPublication_ResultPublication entity);
	
	List<ResultPublication_ResultPublication> findByResultPublication1(ResultPublication resultPublication);
	
	List<ResultPublication_ResultPublication> findByResultPublication2(ResultPublication resultPublication);
	
}
