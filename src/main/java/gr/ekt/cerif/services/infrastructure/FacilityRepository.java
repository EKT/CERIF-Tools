/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for facilities.
 * 
 */
public interface FacilityRepository extends CrudRepository<Facility, String> {

}
