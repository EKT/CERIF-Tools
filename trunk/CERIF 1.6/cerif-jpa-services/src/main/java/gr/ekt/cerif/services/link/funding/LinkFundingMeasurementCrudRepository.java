package gr.ekt.cerif.services.link.funding;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Measurement;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFundingMeasurementCrudRepository extends CrudRepository<Funding_Measurement, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Measurement> findByFunding(Funding funding);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding_Measurement> findByMeasurement(Measurement measurement);

}
