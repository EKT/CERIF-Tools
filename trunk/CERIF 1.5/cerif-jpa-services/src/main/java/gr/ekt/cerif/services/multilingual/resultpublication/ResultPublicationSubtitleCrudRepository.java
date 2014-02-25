/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationSubtitleCrudRepository extends CrudRepository<ResultPublicationSubtitle, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublicationSubtitle> findByResultPublication(ResultPublication resultPublication);

}
