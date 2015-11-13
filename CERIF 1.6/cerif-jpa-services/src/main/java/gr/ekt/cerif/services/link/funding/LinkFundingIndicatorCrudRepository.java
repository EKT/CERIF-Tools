package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFundingIndicatorCrudRepository extends CrudRepository<Funding_Indicator, Long> {
	
	List<Funding_Indicator> findByFunding(Funding funding);
	
	List<Funding_Indicator> findByIndicator(Indicator indicator);

}
