/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MeasurementDescriptionCrudRepository extends CrudRepository<MeasurementDescription, Long> {
	
	List<MeasurementDescription> findByMeasurement(Measurement measurement);

}
