/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CitationDescriptionCrudRepository extends CrudRepository<CitationDescription, Long> {
	
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CitationDescription> findByCitation(Citation citation);

}
