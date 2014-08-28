package gr.ekt.cerif.services.link.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEventMediumCrudRepository extends CrudRepository<Event_Medium, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Medium> findByEvent(Event event);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Medium> findByMedium(Medium medium);

}
