/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxRepository {

	void delete(GeographicBoundingBox entity); 
	
	void delete(Iterable<GeographicBoundingBox> entities); 

	Iterable<GeographicBoundingBox> save(Iterable<GeographicBoundingBox> entities); 
	
	GeographicBoundingBox save(GeographicBoundingBox entity);
	
	List<GeographicBoundingBox> findAll();
	
	Page<GeographicBoundingBox> findAll(Pageable page);

	GeographicBoundingBox findById(Long id);

	List<GeographicBoundingBox> findByUri(String uri);

	GeographicBoundingBox findByUuid(String uuid);
}
