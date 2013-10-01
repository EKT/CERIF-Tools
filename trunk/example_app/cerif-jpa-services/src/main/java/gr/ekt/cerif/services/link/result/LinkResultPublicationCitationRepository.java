package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;

/**
 * A repository for links between resultPublications and citations.
 * 
 */
public interface LinkResultPublicationCitationRepository {

	public void delete(ResultPublication_Citation entity); 
	
	public void delete(Iterable<ResultPublication_Citation> entities); 

	public Iterable<ResultPublication_Citation> save(Iterable<ResultPublication_Citation> entities); 
	
	public ResultPublication_Citation save(ResultPublication_Citation entity);
	
}
