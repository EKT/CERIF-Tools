/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationSubtitleCrudRepository extends CrudRepository<ResultPublicationSubtitle, Long> {
	
	List<ResultPublicationSubtitle> findByResultPublication(ResultPublication resultPublication);

}
