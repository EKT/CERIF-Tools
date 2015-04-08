/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxDescriptionCrudRepository extends CrudRepository<GeographicBoundingBoxDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBoxDescription> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
