/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface FacilityKeywordCrudRepository extends CrudRepository<FacilityKeyword, Long> {
	
	List<FacilityKeyword> findByFacility(Facility facility);

}
