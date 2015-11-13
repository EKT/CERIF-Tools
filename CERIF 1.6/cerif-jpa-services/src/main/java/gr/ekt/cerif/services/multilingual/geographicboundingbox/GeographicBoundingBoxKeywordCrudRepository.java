/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxKeywordCrudRepository extends CrudRepository<GeographicBoundingBoxKeyword, Long> {
	
	List<GeographicBoundingBoxKeyword> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
