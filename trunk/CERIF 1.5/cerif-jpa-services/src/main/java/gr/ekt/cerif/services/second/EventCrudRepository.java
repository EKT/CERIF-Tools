/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Event;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for events.
 * 
 */
public interface EventCrudRepository extends CrudRepository<Event, Long> {

	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Event findById(Long id);
	
}
