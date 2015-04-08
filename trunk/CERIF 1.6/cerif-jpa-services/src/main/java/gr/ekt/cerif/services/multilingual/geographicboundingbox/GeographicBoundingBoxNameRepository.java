/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import java.util.List;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxNameRepository {

	public void delete(GeographicBoundingBoxName entity); 
	
	public void delete(Iterable<GeographicBoundingBoxName> entities); 

	public Iterable<GeographicBoundingBoxName> save(Iterable<GeographicBoundingBoxName> entities); 
	
	public GeographicBoundingBoxName save(GeographicBoundingBoxName entity);
	
	List<GeographicBoundingBoxName> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
}
