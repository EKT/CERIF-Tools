/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxNameCrudRepository extends CrudRepository<GeographicBoundingBoxName, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBoxName> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
