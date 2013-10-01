/**
 * 
 */
package gr.ekt.cerif.services.multilingual.country;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.CountryName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for country name entities.
 * 
 */

public interface CountryNameCrudRepository extends CrudRepository<CountryName, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	CountryName findByName(String name);
	
}

