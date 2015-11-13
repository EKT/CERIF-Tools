/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumTitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MediumTitleCrudRepository extends CrudRepository<MediumTitle, Long> {
	
	List<MediumTitle> findByMedium(Medium medium);

}
