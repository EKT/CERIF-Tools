package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductGeographicBoundingBoxCrudRepository  extends CrudRepository<ResultProduct_GeographicBoundingBox, Long> {
	
	List<ResultProduct_GeographicBoundingBox> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<ResultProduct_GeographicBoundingBox> findByResultProduct(ResultProduct resultProduct);

}
