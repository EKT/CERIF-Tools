/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CitationDescriptionCrudRepository extends CrudRepository<CitationDescription, Long> {
	
	
	List<CitationDescription> findByCitation(Citation citation);

}
