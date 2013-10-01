/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.features.multilingual.EventName;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface EventNameCrudRepository extends CrudRepository<EventName, Long>  {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	EventName findByName(String title);	
	
}

