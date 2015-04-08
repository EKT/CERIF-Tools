/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxKeywordCrudRepository extends CrudRepository<GeographicBoundingBoxKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBoxKeyword> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
