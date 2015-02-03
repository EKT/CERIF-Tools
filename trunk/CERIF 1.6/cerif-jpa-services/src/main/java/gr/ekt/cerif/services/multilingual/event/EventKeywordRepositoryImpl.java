/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventKeyword;

/**
 * @author bonisv
 *
 */
@Component
public class EventKeywordRepositoryImpl implements EventKeywordRepository {

	private static final Logger log = LoggerFactory.getLogger(EventKeywordRepositoryImpl.class);
	
	@Autowired
	private EventKeywordCrudRepository eventKeywordCrudRepository;
	
	@Override
	public void delete(EventKeyword entity) {
		eventKeywordCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<EventKeyword> entities) {
		eventKeywordCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<EventKeyword> save(Iterable<EventKeyword> entities) {
		return eventKeywordCrudRepository.save(entities);
	}

	@Override
	public EventKeyword save(EventKeyword entity) {
		return eventKeywordCrudRepository.save(entity);
	}

	@Override
	public List<EventKeyword> findByEvent(Event event) {
		return eventKeywordCrudRepository.findByEvent(event);
	}

}
