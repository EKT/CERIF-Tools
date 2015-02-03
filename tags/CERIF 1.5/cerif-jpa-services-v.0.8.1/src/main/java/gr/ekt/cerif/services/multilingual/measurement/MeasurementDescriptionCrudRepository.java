/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MeasurementDescriptionCrudRepository extends CrudRepository<MeasurementDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MeasurementDescription> findByMeasurement(Measurement measurement);

}
