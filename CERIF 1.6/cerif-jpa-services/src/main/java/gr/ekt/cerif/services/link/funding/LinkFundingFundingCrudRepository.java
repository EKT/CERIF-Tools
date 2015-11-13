package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFundingFundingCrudRepository extends CrudRepository<Funding_Funding, Long> {
	
	List<Funding_Funding> findByFunding1(Funding funding);
	
	List<Funding_Funding> findByFunding2(Funding funding);
	
	Funding_Funding findByFunding1AndFunding2(Funding funding1, Funding funding2);

}
