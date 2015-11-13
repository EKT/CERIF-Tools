package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultProductKeywordCrudRepository extends CrudRepository<ResultProductKeyword, Long> {
	
	List<ResultProductKeyword> findByResultProduct(ResultProduct resultProduct);

}
