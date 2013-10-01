package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventRepositoryImpl implements EventRepository {

	private static final Logger log = LoggerFactory.getLogger(EventRepositoryImpl.class);

	@Autowired
	private EventCrudRepository eventCrudRepository;
	
	
	@Override
	public Event findById(Long id) {
		return eventCrudRepository.findById(id);
	}

	@Override
	public void delete(Event entity) {
		eventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event> entities) {
		eventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Event> save(Iterable<Event> entities) {
		return eventCrudRepository.save(entities);
	}

	@Override
	public Event save(Event entity) {
		return eventCrudRepository.save(entity);
	}

}
