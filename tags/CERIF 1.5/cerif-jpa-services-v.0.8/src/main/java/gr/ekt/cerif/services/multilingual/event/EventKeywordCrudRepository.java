package gr.ekt.cerif.services.multilingual.event;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface EventKeywordCrudRepository extends CrudRepository<EventKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<EventKeyword> findByEvent(Event event);

}
