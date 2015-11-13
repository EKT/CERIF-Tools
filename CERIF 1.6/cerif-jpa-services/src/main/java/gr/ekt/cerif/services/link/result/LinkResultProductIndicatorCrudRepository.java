package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductIndicatorCrudRepository  extends CrudRepository<ResultProduct_Indicator, Long> {
	
	List<ResultProduct_Indicator> findByIndicator(Indicator indicator);
	
	List<ResultProduct_Indicator> findByResultProduct(ResultProduct resultProduct);

}
