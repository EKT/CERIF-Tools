package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationFundingCrudRepository extends CrudRepository<ResultPublication_Funding, Long> {
	
	List<ResultPublication_Funding> findByFunding(Funding funding);
	
	List<ResultPublication_Funding> findByResultPublication(ResultPublication resultPublication);

}
