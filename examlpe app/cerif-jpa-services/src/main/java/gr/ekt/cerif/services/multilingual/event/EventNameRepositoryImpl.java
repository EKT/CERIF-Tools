/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.EventName;

/**
 * @author bonisv
 *
 */
@Component
public class EventNameRepositoryImpl implements EventNameRepository {

	private static final Logger log = LoggerFactory.getLogger(EventNameRepositoryImpl.class);
	
	@Autowired
	private EventNameCrudRepository eventNameCrudRepository;
	
	@Override
	public EventName findByName(String title) {
		return eventNameCrudRepository.findByName(title);
	}

	@Override
	public void delete(EventName entity) {
		eventNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<EventName> entities) {
		eventNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<EventName> save(Iterable<EventName> entities) {
		return eventNameCrudRepository.save(entities);
	}

	@Override
	public EventName save(EventName entity) {
		return eventNameCrudRepository.save(entity);
	}

}
