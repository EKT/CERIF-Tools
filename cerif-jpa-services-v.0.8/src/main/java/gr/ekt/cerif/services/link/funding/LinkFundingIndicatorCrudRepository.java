package gr.ekt.cerif.services.link.funding;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFundingIndicatorCrudRepository extends CrudRepository<Funding_Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Indicator> findByFunding(Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Indicator> findByIndicator(Indicator indicator);

}
