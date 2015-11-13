package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductResultPatentCrudRepository extends CrudRepository<ResultProduct_ResultPatent, Long> {
		
	List<ResultProduct_ResultPatent> findByResultProduct(ResultProduct resultProduct);
	
	List<ResultProduct_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
