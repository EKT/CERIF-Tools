/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Measurement;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for measurements.
 * 
 */
public interface MeasurementRepository extends CrudRepository<Measurement, String> {

}
