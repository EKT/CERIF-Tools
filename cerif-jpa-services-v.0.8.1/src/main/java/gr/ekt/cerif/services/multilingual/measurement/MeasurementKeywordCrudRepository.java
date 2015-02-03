/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MeasurementKeywordCrudRepository extends CrudRepository<MeasurementKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MeasurementKeyword> findByMeasurement(Measurement measurement);

}
