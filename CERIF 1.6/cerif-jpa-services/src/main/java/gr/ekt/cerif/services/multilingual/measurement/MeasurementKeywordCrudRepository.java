/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MeasurementKeywordCrudRepository extends CrudRepository<MeasurementKeyword, Long> {
	
	List<MeasurementKeyword> findByMeasurement(Measurement measurement);

}
