package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultProductDescriptionCrudRepository extends CrudRepository<ResultProductDescription, Long> {
	
	List<ResultProductDescription> findByResultProduct(ResultProduct resultProduct);

}
