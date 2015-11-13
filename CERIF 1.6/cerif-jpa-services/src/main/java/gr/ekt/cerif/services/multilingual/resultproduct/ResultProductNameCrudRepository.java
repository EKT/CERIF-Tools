package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultProductNameCrudRepository extends CrudRepository<ResultProductName, Long> {
	
	List<ResultProductName> findByResultProduct(ResultProduct resultProduct);

}
