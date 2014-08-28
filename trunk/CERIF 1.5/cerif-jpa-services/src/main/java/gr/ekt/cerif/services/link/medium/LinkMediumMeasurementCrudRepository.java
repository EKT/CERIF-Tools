package gr.ekt.cerif.services.link.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMediumMeasurementCrudRepository extends CrudRepository<Medium_Measurement, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Measurement> findByMeasurement(Measurement measurement);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Measurement> findByMedium(Medium medium);

}
