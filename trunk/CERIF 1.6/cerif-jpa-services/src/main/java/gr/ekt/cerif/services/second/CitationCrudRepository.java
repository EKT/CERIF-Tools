/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Citation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for citations.
 * 
 */
public interface CitationCrudRepository extends CrudRepository<Citation, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Citation> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Citation> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Citation findById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Citation> findByUri(String uri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Citation findByUuid(String uuid);

}
