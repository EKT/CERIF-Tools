package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductMeasurementCrudRepository extends CrudRepository<ResultProduct_Measurement, Long> {
	
	List<ResultProduct_Measurement> findByMeasurement(Measurement measurement);
	
	List<ResultProduct_Measurement> findByResultProduct(ResultProduct resultProduct);

}
