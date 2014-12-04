/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import java.util.List;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationDescription;

/**
 * @author bonisv
 *
 */
public interface CitationDescriptionRepository {
	
	public void delete(CitationDescription entity); 
	
	public void delete(Iterable<CitationDescription> entities); 

	public Iterable<CitationDescription> save(Iterable<CitationDescription> entities); 
	
	public CitationDescription save(CitationDescription entity);
	
	List<CitationDescription> findByCitation(Citation citation);

}
