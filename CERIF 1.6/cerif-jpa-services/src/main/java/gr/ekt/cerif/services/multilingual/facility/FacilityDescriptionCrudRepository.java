/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.multilingual.FacilityDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface FacilityDescriptionCrudRepository extends CrudRepository<FacilityDescription, Long> {
	
	List<FacilityDescription> findByFacility(Facility facility);

}
