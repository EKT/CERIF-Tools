package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Citation;

/**
 * A repository for Citations.
 * @author bonisv
 *
 */
public interface CitationRepository {

	public void delete(Citation entity); 
	
	public void delete(Iterable<Citation> entities); 

	public Iterable<Citation> save(Iterable<Citation> entities); 
	
	public Citation save(Citation entity);
}
