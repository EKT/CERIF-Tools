/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationTitle;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CitationTitleCrudRepository extends CrudRepository<CitationTitle, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CitationTitle> findByCitation(Citation citation);

}
