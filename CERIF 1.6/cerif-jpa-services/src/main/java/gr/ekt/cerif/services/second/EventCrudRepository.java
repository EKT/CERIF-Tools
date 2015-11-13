/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for events.
 * 
 */
public interface EventCrudRepository extends CrudRepository<Event, Long> {

	public Event findById(Long id);
	
	public List<Event> findAll();
	
	public Page<Event> findAll(Pageable page);

	public List<Event> findByUri(String uri);

	public Event findByUuid(String uuid);
	
}
