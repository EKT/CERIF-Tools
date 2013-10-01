/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxRepository {

	public void delete(GeographicBoundingBox entity); 
	
	public void delete(Iterable<GeographicBoundingBox> entities); 

	public Iterable<GeographicBoundingBox> save(Iterable<GeographicBoundingBox> entities); 
	
	public GeographicBoundingBox save(GeographicBoundingBox entity);
}
