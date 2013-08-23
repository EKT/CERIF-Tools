package gr.ekt.cerif.services.link.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Class;

@Component
public class LinkEventClassRepositoryImpl implements LinkEventClassRepository {

	private static final Logger log = LoggerFactory.getLogger(LinkEventClassRepositoryImpl.class);
	
	@Autowired
	private LinkEventClassCrudRepository LinkEventClassCrudRepository;
	
	@Override
	public void delete(Event_Class entity) {
		LinkEventClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event_Class> entities) {
		LinkEventClassCrudRepository.save(entities);
	}

	@Override
	public Iterable<Event_Class> save(Iterable<Event_Class> entities) {
		return LinkEventClassCrudRepository.save(entities);
	}

	@Override
	public Event_Class save(Event_Class entity) {
		return LinkEventClassCrudRepository.save(entity);
	}

}
