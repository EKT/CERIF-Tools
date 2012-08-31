/**
 * 
 */
package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for personNames.
 * 
 */
public interface PersonNameRepository extends CrudRepository<PersonName, Long> {

}
