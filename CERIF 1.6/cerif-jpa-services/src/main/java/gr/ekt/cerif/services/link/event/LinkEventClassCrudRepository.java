package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEventClassCrudRepository extends CrudRepository<Event_Class, Long> {
	
	List<Event_Class> findByEvent(Event event);
	
	List<Event_Class> findBytheClass(Class theClass);

}
