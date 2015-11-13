/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxNameCrudRepository extends CrudRepository<GeographicBoundingBoxName, Long>  {
	
	List<GeographicBoundingBoxName> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
