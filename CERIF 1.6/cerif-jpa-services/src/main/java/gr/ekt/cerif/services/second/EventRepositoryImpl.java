package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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

	@Override
	public List<Event> findAll() {
		return eventCrudRepository.findAll();
	}

	@Override
	public Page<Event> findAll(Pageable page) {
		return eventCrudRepository.findAll(page);
	}

	@Override
	public List<Event> findByUri(String uri) {
		return eventCrudRepository.findByUri(uri);
	}

	@Override
	public Event findByUuid(String uuid) {
		return eventCrudRepository.findByUuid(uuid);
	}

}
