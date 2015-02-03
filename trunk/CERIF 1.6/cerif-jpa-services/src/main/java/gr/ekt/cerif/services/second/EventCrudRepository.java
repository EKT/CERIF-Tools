/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.second.Event;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for events.
 * 
 */
public interface EventCrudRepository extends CrudRepository<Event, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Event findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Event> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Event> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Event> findByUri(String uri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Event findByUuid(String uuid);
	
}
