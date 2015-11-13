package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEventMeasurementCrudRepository extends CrudRepository<Event_Measurement, Long> {
	
	List<Event_Measurement> findByEvent(Event event);
	
	List<Event_Measurement> findByMeasurement(Measurement measurement);

}
