package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEventIndicatorCrudRepository extends CrudRepository<Event_Indicator, Long> {
	
	List<Event_Indicator> findByEvent(Event event);
	
	List<Event_Indicator> findByIndicator(Indicator indicator);

}
