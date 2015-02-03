package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Citation;

/**
 * A repository for links between resultPublications and citations.
 * 
 */
public interface LinkResultPublicationCitationRepository {

	public void delete(ResultPublication_Citation entity); 
	
	public void delete(Iterable<ResultPublication_Citation> entities); 

	public Iterable<ResultPublication_Citation> save(Iterable<ResultPublication_Citation> entities); 
	
	public ResultPublication_Citation save(ResultPublication_Citation entity);
	
	List<ResultPublication_Citation> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Citation> findByCitation(Citation citation);
	
}
