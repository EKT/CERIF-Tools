/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationTitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CitationTitleCrudRepository extends CrudRepository<CitationTitle, Long>  {
	
	List<CitationTitle> findByCitation(Citation citation);

}
