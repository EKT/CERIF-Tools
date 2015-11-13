/**
 * 
 */
package gr.ekt.cerif.services.multilingual.country;

import gr.ekt.cerif.features.multilingual.CountryName;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for country name entities.
 * 
 */

public interface CountryNameCrudRepository extends CrudRepository<CountryName, Long> {

	CountryName findByName(String name);
	
}

