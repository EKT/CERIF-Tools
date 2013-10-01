/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for publications.
 * 
 */
public interface ResultPublicationRepository {

	ResultPublication findByUri(String uri);
	
	ResultPublication findById(Long id);

	public void delete(ResultPublication entity); 
	
	public void delete(Iterable<ResultPublication> entities); 

	public Iterable<ResultPublication> save(Iterable<ResultPublication> entities); 
	
	public ResultPublication save(ResultPublication entity);
}
