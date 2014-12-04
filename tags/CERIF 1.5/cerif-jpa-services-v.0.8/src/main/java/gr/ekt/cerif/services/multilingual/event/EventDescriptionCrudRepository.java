package gr.ekt.cerif.services.multilingual.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface EventDescriptionCrudRepository extends CrudRepository<EventDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<EventDescription> findByEvent(Event event);

}
