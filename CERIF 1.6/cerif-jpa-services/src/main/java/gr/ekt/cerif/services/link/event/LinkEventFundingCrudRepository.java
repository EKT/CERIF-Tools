package gr.ekt.cerif.services.link.event;

import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEventFundingCrudRepository extends CrudRepository<Event_Funding, Long> {
	
	List<Event_Funding> findByEvent(Event event);
	
	List<Event_Funding> findByFunding(Funding funding);

}
