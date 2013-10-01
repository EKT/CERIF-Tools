/**
 * 
 */
package gr.ekt.cerif.services.second;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for mediums.
 * 
 */
public interface MediumCrudRepository extends CrudRepository<Medium, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Medium findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Medium findById(Long id);
	
}
