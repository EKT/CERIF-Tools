package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentFundingCrudRepository extends CrudRepository<ResultPatent_Funding, Long> {
	
	List<ResultPatent_Funding> findByFunding(Funding funding);
	
	List<ResultPatent_Funding> findByResultPatent(ResultPatent resultPatent);

}
