package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEventMediumCrudRepository extends CrudRepository<Event_Medium, Long> {
	
	List<Event_Medium> findByEvent(Event event);
	
	List<Event_Medium> findByMedium(Medium medium);

}
