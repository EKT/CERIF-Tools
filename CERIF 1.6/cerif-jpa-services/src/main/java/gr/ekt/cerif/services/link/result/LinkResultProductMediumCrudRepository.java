package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductMediumCrudRepository extends CrudRepository<ResultProduct_Medium, Long> {
	
	List<ResultProduct_Medium> findByMedium(Medium medium);
	
	List<ResultProduct_Medium> findByResultProduct(ResultProduct resultProduct);

}
