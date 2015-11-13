package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFundingMeasurementCrudRepository extends CrudRepository<Funding_Measurement, Long> {
	
	List<Funding_Measurement> findByFunding(Funding funding);
	
	List<Funding_Measurement> findByMeasurement(Measurement measurement);

}
