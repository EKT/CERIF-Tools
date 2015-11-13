/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface EventNameCrudRepository extends CrudRepository<EventName, Long>  {

	EventName findByName(String title);	
	
	List<EventName> findByEvent(Event event);
	
}

