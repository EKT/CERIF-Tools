package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductResultProductCrudRepository extends CrudRepository<ResultProduct_ResultProduct, Long> {
	
	List<ResultProduct_ResultProduct> findByResultProduct1(ResultProduct resultProduct);
	
	List<ResultProduct_ResultProduct> findByResultProduct2(ResultProduct resultProduct);

}
