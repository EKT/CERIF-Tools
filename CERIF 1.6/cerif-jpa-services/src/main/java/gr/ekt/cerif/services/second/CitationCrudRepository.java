/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Citation;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for citations.
 * 
 */
public interface CitationCrudRepository extends CrudRepository<Citation, Long> {
	
	public List<Citation> findAll();
	
	public Page<Citation> findAll(Pageable page);

	public Citation findById(Long id);

	public List<Citation> findByUri(String uri);

	public Citation findByUuid(String uuid);

}
