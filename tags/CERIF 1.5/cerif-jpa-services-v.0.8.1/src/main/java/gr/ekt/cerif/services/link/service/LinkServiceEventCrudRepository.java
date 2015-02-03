package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.second.Event;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceEventCrudRepository extends CrudRepository<Service_Event, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_Event> findByEvent(Event event);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_Event> findByService(Service service);

}
