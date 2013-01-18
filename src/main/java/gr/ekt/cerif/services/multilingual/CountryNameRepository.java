/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.CountryName;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for country translation entities.
 * 
 */

public interface CountryNameRepository extends CrudRepository<CountryName, Long> {

	CountryName findByName(String name);
}

