package gr.ekt.cerif.services.link.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Event;

@Component
public class LinkEventEventRepositoryImpl implements LinkEventEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEventEventRepositoryImpl.class);
	
	@Autowired
	private LinkEventEventCrudRepository linkEventEventCrudRepository;

	@Override
	public void delete(Event_Event entity) {
		linkEventEventCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<Event_Event> entities) {
		linkEventEventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Event_Event> save(Iterable<Event_Event> entities) {
		return linkEventEventCrudRepository.save(entities);
	}

	@Override
	public Event_Event save(Event_Event entity) {
		return linkEventEventCrudRepository.save(entity);
	}

}
