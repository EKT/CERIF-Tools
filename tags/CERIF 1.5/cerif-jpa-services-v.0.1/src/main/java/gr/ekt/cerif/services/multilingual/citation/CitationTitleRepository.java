/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import java.util.List;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationTitle;

/**
 * @author bonisv
 *
 */
public interface CitationTitleRepository {
	
	public void delete(CitationTitle entity); 
	
	public void delete(Iterable<CitationTitle> entities); 

	public Iterable<CitationTitle> save(Iterable<CitationTitle> entities); 
	
	public CitationTitle save(CitationTitle entity);
	
	List<CitationTitle> findByCitation(Citation citation);

}
