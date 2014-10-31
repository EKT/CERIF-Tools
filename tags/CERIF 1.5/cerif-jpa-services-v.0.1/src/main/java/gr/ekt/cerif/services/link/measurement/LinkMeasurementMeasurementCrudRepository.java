package gr.ekt.cerif.services.link.measurement;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMeasurementMeasurementCrudRepository extends CrudRepository<Measurement_Measurement, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Measurement_Measurement> findByMeasurement1(Measurement measurement);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Measurement_Measurement> findByMeasurement2(Measurement measurement);

}
