package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultProductKeywordCrudRepository extends CrudRepository<ResultProductKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProductKeyword> findByResultProduct(ResultProduct resultProduct);

}
