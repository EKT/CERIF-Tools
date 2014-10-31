/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationBibliographicNoteCrudRepository extends CrudRepository<ResultPublicationBibliographicNote, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublicationBibliographicNote> findByResultPublication(ResultPublication resultPublication);

}
