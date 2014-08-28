package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkIndicatorMeasurementCrudRepository extends CrudRepository<Indicator_Measurement, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator_Measurement> findByMeasurement(Measurement measurement);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator_Measurement> findByIndicator(Indicator indicator);

}
