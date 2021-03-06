package gr.ekt.cerif.services.link.geographicboundingbox;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between geographic bounding boxes and classes.
 * 
 */
public interface LinkGeographicBoundingBoxClassRepository {

	public void delete(GeographicBoundingBox_Class entity); 
	
	public void delete(Iterable<GeographicBoundingBox_Class> entities); 

	public Iterable<GeographicBoundingBox_Class> save(Iterable<GeographicBoundingBox_Class> entities); 
	
	public GeographicBoundingBox_Class save(GeographicBoundingBox_Class entity);
	
	List<GeographicBoundingBox_Class> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<GeographicBoundingBox_Class> findByTheClass(Class theClass);
	
}
