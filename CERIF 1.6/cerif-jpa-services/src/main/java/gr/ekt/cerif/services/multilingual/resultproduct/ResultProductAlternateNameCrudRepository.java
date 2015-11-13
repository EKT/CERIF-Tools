package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductAlternateName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultProductAlternateNameCrudRepository extends CrudRepository<ResultProductAlternateName, Long> {
	
	List<ResultProductAlternateName> findByResultProduct(ResultProduct resultProduct);

}
