package gr.ekt.cerif.services.link.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Medium;

@Component
public class LinkEventMediumRepositoryImpl implements LinkEventMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEventMediumRepositoryImpl.class);
	
	@Autowired
	private LinkEventMediumCrudRepository linkEventMediumCrudRepository;

	@Override
	public void delete(Event_Medium entity) {
		linkEventMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event_Medium> entities) {
		linkEventMediumCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Event_Medium> save(Iterable<Event_Medium> entities) {
		return linkEventMediumCrudRepository.save(entities);
	}

	@Override
	public Event_Medium save(Event_Medium entity) {
		return linkEventMediumCrudRepository.save(entity);
	}

}
