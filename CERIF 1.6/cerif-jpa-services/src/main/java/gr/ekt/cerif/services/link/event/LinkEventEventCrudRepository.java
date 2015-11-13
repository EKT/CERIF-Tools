package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEventEventCrudRepository  extends CrudRepository<Event_Event, Long>{
	
	List<Event_Event> findByEvent1(Event event1);
	
	List<Event_Event> findByEvent2(Event event2);

}
