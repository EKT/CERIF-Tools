package gr.ekt.cerif.services.link.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEventFundingCrudRepository extends CrudRepository<Event_Funding, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Funding> findByEvent(Event event);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Event_Funding> findByFunding(Funding funding);

}
