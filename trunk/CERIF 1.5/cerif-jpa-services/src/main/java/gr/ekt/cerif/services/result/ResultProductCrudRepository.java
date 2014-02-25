package gr.ekt.cerif.services.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultProduct;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultProductCrudRepository extends CrudRepository<ResultProduct, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProduct> findAll();
	
}
