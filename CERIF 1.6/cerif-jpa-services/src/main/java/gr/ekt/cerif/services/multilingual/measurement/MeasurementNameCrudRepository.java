/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MeasurementNameCrudRepository extends CrudRepository<MeasurementName, Long> {
	
	List<MeasurementName> findByMeasurement(Measurement measurement);

}
