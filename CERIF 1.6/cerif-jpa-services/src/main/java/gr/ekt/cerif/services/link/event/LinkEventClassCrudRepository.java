package gr.ekt.cerif.services.link.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEventClassCrudRepository extends CrudRepository<Event_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Class> findByEvent(Event event);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Class> findBytheClass(Class theClass);

}
