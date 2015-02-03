package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultProductVersionInfoCrudRepository extends CrudRepository<ResultProductVersionInfo, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProductVersionInfo> findByResultProduct(ResultProduct resultProduct);

}
