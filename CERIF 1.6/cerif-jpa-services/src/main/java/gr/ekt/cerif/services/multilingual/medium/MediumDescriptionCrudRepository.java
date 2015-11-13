/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MediumDescriptionCrudRepository extends CrudRepository<MediumDescription, Long> {
	
	List<MediumDescription> findByMedium(Medium medium);

}
