package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventDescriptionCrudRepository extends CrudRepository<EventDescription, Long> {
	
	List<EventDescription> findByEvent(Event event);

}
