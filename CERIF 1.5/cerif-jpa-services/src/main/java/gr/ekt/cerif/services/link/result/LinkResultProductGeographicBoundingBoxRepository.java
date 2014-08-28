package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;

/**
 * A repository for links between resultProducts and geographicBoundingBoxes.
 * 
 */
public interface LinkResultProductGeographicBoundingBoxRepository {

	public void delete(ResultProduct_GeographicBoundingBox entity); 
	
	public void delete(Iterable<ResultProduct_GeographicBoundingBox> entities); 

	public Iterable<ResultProduct_GeographicBoundingBox> save(Iterable<ResultProduct_GeographicBoundingBox> entities); 
	
	public ResultProduct_GeographicBoundingBox save(ResultProduct_GeographicBoundingBox entity);
	
	List<ResultProduct_GeographicBoundingBox> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<ResultProduct_GeographicBoundingBox> findByResultProduct(ResultProduct resultProduct);
	
}
