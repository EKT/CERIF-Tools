package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultProductVersionInfoCrudRepository extends CrudRepository<ResultProductVersionInfo, Long> {
	
	List<ResultProductVersionInfo> findByResultProduct(ResultProduct resultProduct);

}
