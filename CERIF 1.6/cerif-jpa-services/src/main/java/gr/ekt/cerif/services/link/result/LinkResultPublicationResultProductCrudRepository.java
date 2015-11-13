package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationResultProductCrudRepository extends CrudRepository<ResultPublication_ResultProduct, Long> {
	
	List<ResultPublication_ResultProduct> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_ResultProduct> findByResultProduct(ResultProduct resultProduct);

}
