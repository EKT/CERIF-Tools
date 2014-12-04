/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

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
}
