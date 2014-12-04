package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductGeographicBoundingBoxCrudRepository  extends CrudRepository<ResultProduct_GeographicBoundingBox, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProduct_GeographicBoundingBox> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProduct_GeographicBoundingBox> findByResultProduct(ResultProduct resultProduct);

}
