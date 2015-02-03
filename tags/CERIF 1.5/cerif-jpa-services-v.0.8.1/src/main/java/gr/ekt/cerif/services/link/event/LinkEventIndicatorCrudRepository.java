package gr.ekt.cerif.services.link.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEventIndicatorCrudRepository extends CrudRepository<Event_Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Indicator> findByEvent(Event event);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Indicator> findByIndicator(Indicator indicator);

}
