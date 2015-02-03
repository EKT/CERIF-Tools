/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;

/**
 * @author bonisv
 *
 */
public interface GeographicBoundingBoxKeywordRepository {

	public void delete(GeographicBoundingBoxKeyword entity); 
	
	public void delete(Iterable<GeographicBoundingBoxKeyword> entities); 

	public Iterable<GeographicBoundingBoxKeyword> save(Iterable<GeographicBoundingBoxKeyword> entities); 
	
	public GeographicBoundingBoxKeyword save(GeographicBoundingBoxKeyword entity);
}
