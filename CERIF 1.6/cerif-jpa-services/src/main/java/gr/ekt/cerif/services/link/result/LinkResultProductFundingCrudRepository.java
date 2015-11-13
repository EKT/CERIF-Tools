package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductFundingCrudRepository extends CrudRepository<ResultProduct_Funding, Long> {
	
	List<ResultProduct_Funding> findByFunding(Funding funding);
	
	List<ResultProduct_Funding> findByResultProduct(ResultProduct resultProduct);

}
