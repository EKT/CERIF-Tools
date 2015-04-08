package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductResultPatentCrudRepository extends CrudRepository<ResultProduct_ResultPatent, Long> {
		
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProduct_ResultPatent> findByResultProduct(ResultProduct resultProduct);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultProduct_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
