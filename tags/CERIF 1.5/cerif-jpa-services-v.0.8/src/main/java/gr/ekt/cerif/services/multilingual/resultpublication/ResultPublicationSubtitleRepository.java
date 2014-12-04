/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationSubtitleRepository {
	
	public void delete(ResultPublicationSubtitle entity); 
	
	public void delete(Iterable<ResultPublicationSubtitle> entities); 

	public Iterable<ResultPublicationSubtitle> save(Iterable<ResultPublicationSubtitle> entities); 
	
	public ResultPublicationSubtitle save(ResultPublicationSubtitle entity);
	
	List<ResultPublicationSubtitle> findByResultPublication(ResultPublication resultPublication);

}
