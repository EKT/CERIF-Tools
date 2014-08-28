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
import gr.ekt.cerif.features.multilingual.EventDescription;

/**
 * @author bonisv
 *
 */
@Component
public class EventDescriptionRepositoryImpl implements EventDescriptionRepository {

	private static final Logger log = LoggerFactory.getLogger(EventDescriptionRepositoryImpl.class);
	
	@Autowired
	private EventDescriptionCrudRepository eventDescriptionCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.EventDescriptionRepository#delete(gr.ekt.cerif.features.multilingual.EventDescription)
	 */
	@Override
	public void delete(EventDescription entity) {
		eventDescriptionCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.EventDescriptionRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<EventDescription> entities) {
		eventDescriptionCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.EventDescriptionRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<EventDescription> save(Iterable<EventDescription> entities) {
		return eventDescriptionCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.EventDescriptionRepository#save(gr.ekt.cerif.features.multilingual.EventDescription)
	 */
	@Override
	public EventDescription save(EventDescription entity) {
		return eventDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<EventDescription> findByEvent(Event event) {
		return eventDescriptionCrudRepository.findByEvent(event);
	}

}
