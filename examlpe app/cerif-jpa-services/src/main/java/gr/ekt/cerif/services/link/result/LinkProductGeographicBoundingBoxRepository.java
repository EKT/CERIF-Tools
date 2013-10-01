package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;

/**
 * A repository for links between classes and bounding boxes.
 * 
 */
public interface LinkProductGeographicBoundingBoxRepository {
	
	public void delete(ResultProduct_GeographicBoundingBox entity); 
	
	public void delete(Iterable<ResultProduct_GeographicBoundingBox> entities); 

	public Iterable<ResultProduct_GeographicBoundingBox> save(Iterable<ResultProduct_GeographicBoundingBox> entities); 
	
	public ResultProduct_GeographicBoundingBox save(ResultProduct_GeographicBoundingBox entity);

}
