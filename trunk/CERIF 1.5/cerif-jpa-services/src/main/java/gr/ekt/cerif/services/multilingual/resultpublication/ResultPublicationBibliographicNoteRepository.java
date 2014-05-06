/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationBibliographicNoteRepository {
	
	public void delete(ResultPublicationBibliographicNote entity); 
	
	public void delete(Iterable<ResultPublicationBibliographicNote> entities); 

	public Iterable<ResultPublicationBibliographicNote> save(Iterable<ResultPublicationBibliographicNote> entities); 
	
	public ResultPublicationBibliographicNote save(ResultPublicationBibliographicNote entity);
	
	List<ResultPublicationBibliographicNote> findByResultPublication(ResultPublication resultPublication);

}
