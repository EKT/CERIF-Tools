/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import java.util.List;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxDescriptionRepository {
	
	public void delete(GeographicBoundingBoxDescription entity); 
	
	public void delete(Iterable<GeographicBoundingBoxDescription> entities); 

	public Iterable<GeographicBoundingBoxDescription> save(Iterable<GeographicBoundingBoxDescription> entities); 
	
	public GeographicBoundingBoxDescription save(GeographicBoundingBoxDescription entity);
	
	List<GeographicBoundingBoxDescription> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);

}
