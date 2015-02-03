package gr.ekt.cerif.services.link.funding;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFundingFundingCrudRepository extends CrudRepository<Funding_Funding, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Funding> findByFunding1(Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Funding> findByFunding2(Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Funding_Funding findByFunding1AndFunding2(Funding funding1, Funding funding2);

}
