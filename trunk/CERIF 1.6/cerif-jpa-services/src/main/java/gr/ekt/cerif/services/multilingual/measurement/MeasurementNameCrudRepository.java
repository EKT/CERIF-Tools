/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MeasurementNameCrudRepository extends CrudRepository<MeasurementName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MeasurementName> findByMeasurement(Measurement measurement);

}
