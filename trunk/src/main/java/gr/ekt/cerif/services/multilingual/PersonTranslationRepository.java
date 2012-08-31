/**
 * 
 */
package gr.ekt.cerif.services.multilingual;
import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface PersonTranslationRepository extends CrudRepository <PersonName, Long> {

	
}

