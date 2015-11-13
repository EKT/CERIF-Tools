package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityEventCrudRepository extends CrudRepository<Facility_Event, Long> {
	
	List<Facility_Event> findByFacility(Facility facility);
	
	List<Facility_Event> findByEvent(Event event);

}
