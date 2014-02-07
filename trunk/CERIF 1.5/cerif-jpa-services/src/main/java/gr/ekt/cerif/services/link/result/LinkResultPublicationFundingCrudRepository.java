package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationFundingCrudRepository extends CrudRepository<ResultPublication_Funding, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Funding> findByFunding(Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Funding> findByResultPublication(ResultPublication resultPublication);

}
