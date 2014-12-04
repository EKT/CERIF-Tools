/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface FacilityKeywordCrudRepository extends CrudRepository<FacilityKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<FacilityKeyword> findByFacility(Facility facility);

}
