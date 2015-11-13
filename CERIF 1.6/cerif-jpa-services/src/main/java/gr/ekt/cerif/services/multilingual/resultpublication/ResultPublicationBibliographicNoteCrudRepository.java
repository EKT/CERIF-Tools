/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationBibliographicNoteCrudRepository extends CrudRepository<ResultPublicationBibliographicNote, Long> {
	
	List<ResultPublicationBibliographicNote> findByResultPublication(ResultPublication resultPublication);

}
