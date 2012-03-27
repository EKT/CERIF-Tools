/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Event;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for events.
 * 
 */
public interface EventRepository extends CrudRepository<Event, String> {

}
