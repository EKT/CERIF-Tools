package gr.ekt.cerif.services.link.geographicboundingbox;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;

/**
 * A repository for links between geographic bounding boxes.
 * 
 */
public interface LinkGeographicBoundingBoxGeographicBoundingBoxRepository {

	public void delete(GeographicBoundingBox_GeographicBoundingBox entity); 
	
	public void delete(Iterable<GeographicBoundingBox_GeographicBoundingBox> entities); 

	public Iterable<GeographicBoundingBox_GeographicBoundingBox> save(Iterable<GeographicBoundingBox_GeographicBoundingBox> entities); 
	
	public GeographicBoundingBox_GeographicBoundingBox save(GeographicBoundingBox_GeographicBoundingBox entity);
	
}
