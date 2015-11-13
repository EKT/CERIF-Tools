/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxDescriptionCrudRepository extends CrudRepository<GeographicBoundingBoxDescription, Long> {
	
	List<GeographicBoundingBoxDescription> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
