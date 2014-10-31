package gr.ekt.cerif.services.link.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMediumFundingCrudRepository extends CrudRepository<Medium_Funding, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Funding> findByFunding(Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Funding> findByMedium(Medium medium);

}
