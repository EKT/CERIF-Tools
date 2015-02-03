package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductAlternateName;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultProductAlternateNameCrudRepository extends CrudRepository<ResultProductAlternateName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProductAlternateName> findByResultProduct(ResultProduct resultProduct);

}
