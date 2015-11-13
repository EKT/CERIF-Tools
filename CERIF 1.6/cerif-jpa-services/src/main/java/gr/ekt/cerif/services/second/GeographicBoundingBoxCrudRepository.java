/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface GeographicBoundingBoxCrudRepository extends CrudRepository<GeographicBoundingBox, Long> {
	
	public List<GeographicBoundingBox> findAll();
	
	public Page<GeographicBoundingBox> findAll(Pageable page);

	public GeographicBoundingBox findById(Long id);

	public List<GeographicBoundingBox> findByUri(String uri);

	public GeographicBoundingBox findByUuid(String uuid);

}
