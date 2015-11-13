package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventKeywordCrudRepository extends CrudRepository<EventKeyword, Long> {
	
	List<EventKeyword> findByEvent(Event event);

}
