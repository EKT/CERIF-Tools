package gr.ekt.cerif.services.link.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.second.Event;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEventEventCrudRepository  extends CrudRepository<Event_Event, Long>{
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Event> findByEvent1(Event event1);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Event> findByEvent2(Event event2);

}
