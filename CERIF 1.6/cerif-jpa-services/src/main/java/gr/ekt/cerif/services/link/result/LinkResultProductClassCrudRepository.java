package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductClassCrudRepository  extends CrudRepository<ResultProduct_Class, Long> {
	
	List<ResultProduct_Class> findByResultProduct(ResultProduct resultProduct);
	
	List<ResultProduct_Class> findBytheClass(Class theClass);

}
